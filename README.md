### 1. Users

- [x]  **사용자 회원가입 O**
    
    POST /api/signup
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/803dc6ca-343e-4ac8-b2db-df0d84c29494/2a0dcdf6-23dc-4c92-9cfb-9496c65ccdf2/Untitled.png)
    
- [x]  **사용자 로그인 O**
    
    POST /api/login
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/803dc6ca-343e-4ac8-b2db-df0d84c29494/4c58a1aa-4e61-4d33-ab5d-f47affaa7195/Untitled.png)
    

### 2. Goods 로그인해야 좋아요 등록 가능

- [x]  농촌 체험 좋아요/ 좋아요 취소  O  - 활동신청 버튼에서  **농가 화면을 눌렀을때 농가 정보가 상세 조회되는데 거기서 좋아요 버튼 기능 추가해주세요!**
    
    POST /api/good
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/803dc6ca-343e-4ac8-b2db-df0d84c29494/cdca1b33-a00c-4379-a2f5-a848a22a737e/Untitled.png)
    
- [x]  내가 최근에 좋아요한 1개  장소 조회 O- 최근 좋아요 누른 **농장이름 농장지역 이미지**
    
    **GET /api/good/recent**
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/803dc6ca-343e-4ac8-b2db-df0d84c29494/6dcaac03-dadf-48ce-8d1b-bcb6e627785b/Untitled.png)
    
- [x]  내가 좋아요한 전체 장소 조회 O -  **농장이름 농장지역 이미지**
    
    GET /api/good/{userId}
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/803dc6ca-343e-4ac8-b2db-df0d84c29494/37f199f0-08d7-4765-8c11-b5dd6b7e41c7/Untitled.png)
    

### 3. Comments (로그인해야 후기 등록)

- [x]  **후기 등록 O**
    
    POST /api/comment
    
- [x]  **후기 수정 O**
    
    PATCH /api/comment/{commentId}
    
- [x]  **후기 삭제 O**
    
    DELETE /api/comment/{commentId}
    
- [x]  **1개의** **농가 후기 전체 조회 O  (활동신청버튼에서 농가화면 누른후 농가 후기버튼 눌렀을때)**
    
    **GET /api/comment/farm/{farmId}**
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/803dc6ca-343e-4ac8-b2db-df0d84c29494/259ad0af-56e6-42c7-936b-c8c6285bd145/Untitled.png)
    
- [x]  **농가 후기 전체 조회 O - 커뮤니티버튼에서 최근 후기 더보기 눌렀을때**
    
    GET /api/comment
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/803dc6ca-343e-4ac8-b2db-df0d84c29494/40861c06-4ff6-4f66-ae54-33014ffeb5ce/Untitled.png)
    
- [x]  **농가 후기 전체 조회중 최근 3개 조회 O - 커뮤니티버튼에서 보이는 화면**
    
    **GET /api/comment/recent**
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/803dc6ca-343e-4ac8-b2db-df0d84c29494/ca419f40-91b4-4fe8-bd60-f321dcca662d/Untitled.png)
    
- [x]  최근 **내가 작성한 후기 1개 조회 O- 홈버튼 화면에서 최근 내가 작성한 리뷰 1개가 보임**
    
    **GET /api/comment/user/recent/{userId}**
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/803dc6ca-343e-4ac8-b2db-df0d84c29494/7fba0dd1-65ec-4034-bf67-953c65b2d13a/Untitled.png)
    
- [x]  **내가 작성한 후기 전체 조회 O - 홈버튼 화면에서 최근 내가 작성한 리뷰를 눌렀을때**
    
    GET /api/comment/user/{userId}
    

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/803dc6ca-343e-4ac8-b2db-df0d84c29494/1d307dd1-a917-4924-a76d-f65f006b1bc0/Untitled.png)

### 4. Farms 로그인 안해도 등록 가능

- [x]  농가 정보 등록 O
    
    POST /api/farm
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/803dc6ca-343e-4ac8-b2db-df0d84c29494/3e38a501-866b-45f8-a922-4934b394406a/Untitled.png)
    
- [x]  농가 전체 리스트 조회 O
    
    GET /api/farm
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/803dc6ca-343e-4ac8-b2db-df0d84c29494/512fd720-ab01-4539-bc51-20ad33705cf9/Untitled.png)
    
- [x]  농가 1개 상세 조회 O (한 농장의 좋아요 개수 포함)
    
    GET /api/farm/{farmId}
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/803dc6ca-343e-4ac8-b2db-df0d84c29494/e0063504-3d0f-4a98-b041-1465f6a19c4d/Untitled.png)
    

- [x]  농가 지역region별  카테고리 검색 O - 활동신청버튼에서 나오는 것들
    
     GET /api/farm/search?regName=서울
    
    **서울말고**
    
    **경기 인천 강원 충청 경상 전라 제주**
    
    를 넣어서 해도 결과 조회되도록!
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/803dc6ca-343e-4ac8-b2db-df0d84c29494/f2ada0cb-1456-4509-8795-82809f083e02/Untitled.png)
    

### 5. Profiles 로그인해야 보임

- [x]  회원가입할때 등록한 정보(닉네임 사용자이메일 ) 조회 O
    
    GET /api/profile/{userId}
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/803dc6ca-343e-4ac8-b2db-df0d84c29494/fbf7aa9e-b7cc-42b0-b6e0-bba3697bfdcd/Untitled.png)
