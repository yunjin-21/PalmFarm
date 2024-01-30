package unis.palmfarm.thymeleaf;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import unis.palmfarm.farm.dto.FarmDetailResponseDTO;
import unis.palmfarm.farm.dto.FarmRequestDTO;
import unis.palmfarm.farm.dto.FarmResponseDTO;
import unis.palmfarm.farm.entity.FarmEntity;
import unis.palmfarm.farm.service.FarmService;
import unis.palmfarm.good.dto.GoodRequestDTO;
import unis.palmfarm.good.service.GoodService;
import unis.palmfarm.user.dto.LoginDTO;
import unis.palmfarm.user.dto.UserDTO;
import unis.palmfarm.user.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserSignupSignInFarm {

    private final FarmService farmService;
    //slf4j를 대체함 Logger log = LoggerFactory.getLogger(getClass());
    private final UserService userService;
    private final GoodService goodService;
    @GetMapping("/user/signup")
    public String signup(){
        log.info("signup controller");
        return "signup"; // signup.html로 찾아감
    }

    @PostMapping("/user/signup")
    public String signup(@ModelAttribute UserDTO userDTO){
        userService.signup(userDTO);
        return "index";
    }

    @GetMapping("/user/login")
    public String loginForm(){
        return "login";
    }
/*
    @PostMapping("/user/login")
    public String login(@ModelAttribute LoginDTO loginDTO, @ModelAttribute FarmRequestDTO farmRequestDTO, Model model){
        UserDTO userDTO = userService.login(loginDTO);
        model.addAttribute("nickname", userDTO.getNickname());

        model.addAttribute("name", farmRequestDTO.getName());
        model.addAttribute("region", farmRequestDTO.getRegion());

        List<FarmEntity> farms = farmService.findFarm();
        model.addAttribute("farms",farms);

        return "index";
    }

*/
    @GetMapping("/farm")
    public String farm(){
        return "farm";
    }

    @PostMapping("/farm")
    public String farm(@ModelAttribute FarmRequestDTO farmRequestDTO, Model model){
        farmService.saveFarm(farmRequestDTO);
        model.addAttribute("name", farmRequestDTO.getName());
        model.addAttribute("region", farmRequestDTO.getRegion());

        List<FarmEntity> farms = farmService.findFarm();
         model.addAttribute("farms",farms);

        return "index";
    }

    /*@GetMapping("/farm/{farmId}")
    public String findOneFarm(@PathVariable("farmId") Long farmId, Model model){
        Optional<FarmDetailResponseDTO> farmDetailResponseDTO = farmService.findById(farmId);
        model.addAttribute("name", farmDetailResponseDTO.get().getName());
        model.addAttribute("region", farmDetailResponseDTO.get().getRegion());
        model.addAttribute("address", farmDetailResponseDTO.get().getAddress());
        //model.addAttribute("info", farmDetailResponseDTO.get().getInfo());

        return "farmdetail";
    }
*/
    /*@PostMapping("/farm/{farmId}")
    public String goodFarm(@PathVariable("farmId")Long farmId, @ModelAttribute GoodRequestDTO goodRequestDTO, Model model){
        boolean flag = goodService.good(goodRequestDTO);
        model.addAttribute("flag",flag);

        //model.addAttribute("userId", goodRequestDTO.getUserId());
    return "farmdetail";
    }*/


















    @GetMapping("/")
    public String basic(){
        return "index";
    }
}
