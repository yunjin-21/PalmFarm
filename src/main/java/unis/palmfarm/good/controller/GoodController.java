package unis.palmfarm.good.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unis.palmfarm.good.dto.GoodRequestDTO;
import unis.palmfarm.good.dto.GoodResponseDTO;
import unis.palmfarm.good.service.GoodService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GoodController {
    private final GoodService goodService;

    @PostMapping("api/good")
    public void goodFarm(@Valid @RequestBody GoodRequestDTO goodRequestDTO){
        goodService.good(goodRequestDTO);
    }

    //내가 좋아요한 전체 장소 조회
    @GetMapping("/api/good/{userId}")
    public List<GoodResponseDTO> userGood(@PathVariable(value = "userId") Long userId){
        return goodService.userGoodList(userId);
    }

    //내가 좋아요한 최근 1개 장소 조회
    @GetMapping("/api/good/recent")
    public GoodResponseDTO userRecentGood(){
        return goodService.userGoodRecent();
    }


}
