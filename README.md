### 1. Users

- [x]  **사용자 회원가입 O**
    
     **POST /api/signup**
    
- [x]  **사용자 로그인 O**
    
    **POST /api/login**


### 2. Goods 로그인해야 좋아요 등록 가능

- [x]   **농촌 체험 좋아요/ 좋아요 취소  O**
    
     **POST /api/good**
 

    
- [x]   **내가 최근에 좋아요한 1개  장소 조회 O -  최근 좋아요 누른 농장이름 농장지역 이미지**
    
    **GET /api/good/recent**
    

    
- [x]  **내가 좋아요한 전체 장소 조회 O -  농장이름 농장지역 이미지**
    
    **GET /api/good/{userId}**
    

    

### 3. Comments (로그인해야 후기 등록)

- [x]  **후기 등록 O**
    
    **POST /api/comment**
    
- [x]  **후기 수정 O**
    
    **PATCH /api/comment/{commentId}**
    
- [x]  **후기 삭제 O**
    
    **DELETE /api/comment/{commentId}**
    
- [x]  **1개의** **농가 후기 전체 조회 O  (활동신청버튼에서 농가화면 누른후 농가 후기버튼 눌렀을때)**
    
    **GET /api/comment/farm/{farmId}**
    
  
    
- [x]  **농가 후기 전체 조회 O - 커뮤니티버튼에서 최근 후기 더보기 눌렀을때**
    
    **GET /api/comment**
    
   
    
- [x]  **농가 후기 전체 조회중 최근 3개 조회 O - 커뮤니티버튼에서 보이는 화면**
    
    **GET /api/comment/recent**
    

    
- [x]  **최근 내가 작성한 후기 1개 조회 O- 홈버튼 화면에서 최근 내가 작성한 리뷰 1개가 보임**
    
    **GET /api/comment/user/recent/{userId}**
    

    
- [x]  **내가 작성한 후기 전체 조회 O - 홈버튼 화면에서 최근 내가 작성한 리뷰를 눌렀을때**
    
    **GET /api/comment/user/{userId}**
    



### 4. Farms 로그인 안해도 등록 가능

- [x]  **농가 정보 등록 O**
    
    **POST /api/farm**
    

    
- [x]  **농가 전체 리스트 조회 O**
    
    **GET /api/farm**
    

    
- [x]  **농가 1개 상세 조회 O (한 농장의 좋아요 개수 포함)**
    
    **GET /api/farm/{farmId}**

    

- [x]  **농가 지역region별  카테고리 검색 O - 활동신청버튼에서 나오는 것들**
    
     **GET /api/farm/search?regName=서울**
    
    

### 5. Profiles 로그인해야 보임

- [x]  **회원가입할때 등록한 정보(닉네임 사용자이메일 ) 조회 O**
    
    **GET /api/profile/{userId}**
    

