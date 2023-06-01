<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <link href="style/main.css" rel="stylesheet" type="text/css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Lobster&display=swap"
      rel="stylesheet"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Francois+One&display=swap"
      rel="stylesheet"
    />
    <title>justgram</title>
    <link
      href="https://cdn-icons.flaticon.com/png/512/4138/premium/4138124.png?token=exp=1659340352~hmac=2e9c85889b6c5b3ce0c9b3822c3f07ed"
      rel="shortcut icon"
      type="image/x-icon"
    />
  </head>
  <style>
  body {
  background-color: rgb(243, 243, 243);
}

.align-center {
  display: flex;
  align-items: center;
}

.navbar {
  border: 1px solid lightgray;
  background-color: white;

  height: 80px;
  display: flex;
  flex-direction: row;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
}

.flex-row {
  display: flex;
  flex-direction: row;
}

.flex-center {
  display: flex;
  justify-content: center;
  align-items: center;
}

.font-bold {
  font-weight: bold;
}

.header-block {
  width: 100%;
  height: inherit;
}

.left-line {
  border: 1px solid black;
  display: flex;
  flex-direction: row;
  height: 80%;
  margin-top: 6px;
}

.borderline2 {
  width: 300px;
  height: 30px;
}

.searching-bar {
  display: flex;
  justify-content: center;
  align-items: center;
}

.div3icon {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}

.borderline3 {
  width: 50px;
  margin-left: 35px;
}

.feed-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 120px;
  margin-right: 400px;
}

.feed-container2 {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: px;
  margin-right: 400px;
}

.feed {
  width: 40%;
  border: 1px solid lightgray;
  margin-bottom: 50px;
  background-color: white;
  border-radius: 5px;
}

.feed-head {
  width: 100%;
  height: 7%;
  display: flex;
  flex-direction: row;
  align-items: center;
}

.feed-left {
  width: 100%;
  display: flex;
  justify-content: flex-start;
  padding-left: 15px;
}

.feed-right {
  width: 100%;
  display: flex;
  justify-content: end;
  padding-right: 15px;
}

.feed-photo {
  width: 100%;
  height: 65%;
}
.feed-menu {
  display: flex;
  flex-direction: row;
  justify-content: space-between;

  width: 100%;
  height: 6%;
}
.feed-text {
  width: 100%;
}

.left-icon {
  max-width: 15%;
  max-height: 60%;
  padding-right: 20px;
}

.leftarea-icon {
  display: flex;
  justify-content: end;
  align-items: center;
}

.leftarea-text {
  font-size: 50px;
  font-family: Lobster;
  padding-left: 30px;
}

.searching {
  width: 270px;
  height: inherit;
  font-size: 20px;
  text-align: center;
  border: 1px solid lightgray;
  border-radius: 5px;
  background-color: #fdfcfc;
}

.profileimg {
  width: 50px;
  padding-right: 15px;
}

.profile-id {
  font-family: "Francois One", sans-serif;
}

.moreimg {
  width: 20px;
}

.photo {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.menu-left-icon {
  width: 35px;
  padding-left: 10px;
}

.menu-right-icon {
  width: 35px;
  padding-right: 10px;
}

.menu-icon-div {
  display: flex;
  align-items: center;
  height: 100%;
}

.text-img {
  width: 25px;
}

.like-text {
  width: inherit;
  height: 20px;
  display: flex;
  align-items: center;
  padding: 2px 15px;
}
.like-text span {
  padding-left: 5px;
  font-size: 15px;
}

.writing {
  padding-top: 10px;
  padding-left: 15px;
  font-size: 14px;
}

.more-text {
  color: #6868689a;
}

.feed ul {
  margin: 5px -10px;
}

.feed ul li {
  font-size: 14px;
  list-style: none;
}

.nickname {
  font-weight: bold;
}

.comment-like-img {
  width: 10px;
  padding-right: 20px;
}

.text-time {
  padding-left: 15px;
  font-size: 16px;
  color: #52525291;
}

.comment-input-container {
  border-top: 1px solid lightgray;
  width: 100%;
  height: 73px;
  display: flex;
  flex-direction: row;
  align-items: center;
}

.comment-input-width {
  width: 100%;
  padding-top: 7px;
}

.comment-input {
  width: 95%;
  height: 50px;
  border: none;
  padding-left: 10px;
  font-size: 16px;
}

.comment-input::placeholder {
  font-size: 16px;
  color: #52525291;
}

.comment-btn {
  width: 80px;
  height: 73px;
  background-color: white;
  font-size: 16px;
  font-weight: bold;
  color: #b6dffa;
  border: none;
}
  
  </style>
  <body>
    <!-- 네비바 -->
    <nav class="navbar">
      <!-- 네비바 왼쪽부분 -->
      <div class="header-block flex-row">
        <!-- 네비 왼쪽안에 왼쪽 -->
        <div class="header-block leftarea-icon">
          <img class="left-icon" src="img/instagram.png" />
        </div>
        <!-- 네비 왼쪽구역 가운데 -->
        <div class="left-line"></div>
        <!-- 네비 왼쪽구역 안의 오른쪽 -->
        <div class="header-block">
          <a class="leftarea-text">justgram</a>
        </div>
      </div>
      <!-- 네비바 가운데 부분 -->
      <div class="header-block searching-bar">
        <!-- 검색바 컨테이너 -->
        <div class="borderline2 flex-center">
          <input class="searching" type="search" placeholder="검색" />
        </div>
      </div>
      <!-- 네비바 오른쪽부분 -->
      <div class="header-block div3icon">
        <div class="borderline3">
          <a
            ><img
              src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/bearu/explore.png"
          /></a>
        </div>
        <div class="borderline3">
          <a
            ><img
              src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/bearu/heart.png"
          /></a>
        </div>
        <div class="borderline3">
          <a
            ><img
              src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/bearu/profile.png"
          /></a>
        </div>
      </div>
    </nav>

    <!-- 피드 구역 -->
    <div class="feed-container">
      <!-- 피드 -->
      <div class="feed">
        <!-- 피드 내부 -->
        <div class="feed-head">
          <!-- 피드헤드의 사진 아이디칸 -->
          <div class="feed-left">
            <div class="align-center">
              <img src="/img/user.png" / class="profileimg">
            </div>
            <div class="align-center">
              <span class="profile-id">profile</span>
            </div>
          </div>
          <!-- 피드헤드의 더보기칸 -->
          <div class="feed-right">
            <div><img src="/img/more.png" / class="moreimg"></div>
          </div>
        </div>
        <!-- 피드 사진칸 -->
        <div class="feed-photo">
          <img
            class="photo"
            src="https://images.unsplash.com/photo-1659482023691-04d925fb35fa?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwzfHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=500&q=60"
          />
        </div>
        <!-- 피드 메뉴 -->
        <div class="feed-menu">
          <div class="menu-icon-div">
            <!-- 피드 메뉴 좌측 아이콘 -->
            <img class="menu-left-icon" src="/img/heart1.png" />
            <img class="menu-left-icon" src="/img/chat.png" />
            <img class="menu-left-icon" src="/img/share.png" />
          </div>
          <!-- 피드메뉴 우측 아이콘 -->
          <div class="menu-icon-div">
            <img class="menu-right-icon" src="/img/mark.png" />
          </div>
        </div>
        <!-- 피드 댓글부분 -->
        <div class="feed-text">
          <!-- 좋아합니다 부분 -->
          <div class="like-text">
            <!-- 프로필이미지와 텍스트 -->
            <img class="text-img" src="/img/user.png" />
            <span class="nickname"
              >junyoung</span>님 외 <span class="font-bold">10명</span>이
              좋아합니다</span
            >
          </div>
          <!-- 피드설명 -->
          <div class="writing">
            <span class="nickname">cannon_mj</span>
            <span>위워크에서 진행한 우주선 클래스...</span>
            <span class="more-text">더 보기</span>
          </div>
          <!-- 댓글 창 -->
          <ul class="comment-ul">
            <li>
              <span class="nickname"> neceosecius </span>
              <span class="comment-text">거봐 좋았잖아~~~~🤷‍♀️</span>
            </li>
            <li>
              <span class="nickname"> neceosecius </span>
              <span class="comment-text">거봐 좋았잖아~~~~🤷‍♀️</span>
            </li>
          </ul>
          <!-- 시간표시 -->
          <div class="text-time">
            <span>42분 전</span>
          </div>
          <!-- 댓글인풋 -->
          <div class="comment-input-container">
            <div class="comment-input-width">
              <input
                class="comment-input"
                type="text"
                placeholder="댓글 달기..."
              />
            </div>
            <!-- 버튼인풋 -->
            <div class="comment-btn-container">
              <button class="comment-btn" disabled>게시</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 다음 추가할 피드는 css container 2적용바람! -->
    <div class="feed-container2">
      <!-- 피드 -->
      <div class="feed">
        <!-- 피드 내부 -->
        <div class="feed-head">
          <!-- 피드헤드의 사진 아이디칸 -->
          <div class="feed-left">
            <div class="align-center">
              <img src="/img/user.png" / class="profileimg">
            </div>
            <div class="align-center">
              <span class="profile-id">profile</span>
            </div>
          </div>
          <!-- 피드헤드의 더보기칸 -->
          <div class="feed-right">
            <div><img src="/img/more.png" / class="moreimg"></div>
          </div>
        </div>
        <!-- 피드 사진칸 -->
        <div class="feed-photo">
          <img
            class="photo"
            src="https://images.unsplash.com/photo-1659482023691-04d925fb35fa?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwzfHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=500&q=60"
          />
        </div>
        <!-- 피드 메뉴 -->
        <div class="feed-menu">
          <div class="menu-icon-div">
            <!-- 피드 메뉴 좌측 아이콘 -->
            <img class="menu-left-icon" src="/img/heart1.png" />
            <img class="menu-left-icon" src="/img/chat.png" />
            <img class="menu-left-icon" src="/img/share.png" />
          </div>
          <!-- 피드메뉴 우측 아이콘 -->
          <div class="menu-icon-div">
            <img class="menu-right-icon" src="/img/mark.png" />
          </div>
        </div>
        <!-- 피드 댓글부분 -->
        <div class="feed-text">
          <!-- 좋아합니다 부분 -->
          <div class="like-text">
            <!-- 프로필이미지와 텍스트 -->
            <img class="text-img" src="/img/user.png" />
            <span class="nickname"
              >junyoung</span>님 외 <span class="font-bold">10명</span>이
              좋아합니다</span
            >
          </div>
          <!-- 피드설명 -->
          <div class="writing">
            <span class="nickname">cannon_mj</span>
            <span>위워크에서 진행한 우주선 클래스...</span>
            <span class="more-text">더 보기</span>
          </div>
          <!-- 댓글 창 -->
          <ul class="comment-ul">
            <li>
              <span class="nickname"> neceosecius </span>
              <span class="comment-text">거봐 좋았잖아~~~~🤷‍♀️</span>
            </li>
            <li>
              <span class="nickname"> neceosecius </span>
              <span class="comment-text">거봐 좋았잖아~~~~🤷‍♀️</span>
            </li>
          </ul>
          <!-- 시간표시 -->
          <div class="text-time">
            <span>42분 전</span>
          </div>
          <!-- 댓글인풋 -->
          <div class="comment-input-container">
            <div class="comment-input-width">
              <input
                class="comment-input"
                type="text"
                placeholder="댓글 달기..."
              />
            </div>
            <!-- 버튼인풋 -->
            <div class="comment-btn-container">
              <button class="comment-btn" disabled>게시</button>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="feed-container2">
      <!-- 피드 -->
      <div class="feed">
        <!-- 피드 내부 -->
        <div class="feed-head">
          <!-- 피드헤드의 사진 아이디칸 -->
          <div class="feed-left">
            <div class="align-center">
              <img src="/img/user.png" / class="profileimg">
            </div>
            <div class="align-center">
              <span class="profile-id">profile</span>
            </div>
          </div>
          <!-- 피드헤드의 더보기칸 -->
          <div class="feed-right">
            <div><img src="/img/more.png" / class="moreimg"></div>
          </div>
        </div>
        <!-- 피드 사진칸 -->
        <div class="feed-photo">
          <img
            class="photo"
            src="https://images.unsplash.com/photo-1659482023691-04d925fb35fa?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwzfHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=500&q=60"
          />
        </div>
        <!-- 피드 메뉴 -->
        <div class="feed-menu">
          <div class="menu-icon-div">
            <!-- 피드 메뉴 좌측 아이콘 -->
            <img class="menu-left-icon" src="/img/heart1.png" />
            <img class="menu-left-icon" src="/img/chat.png" />
            <img class="menu-left-icon" src="/img/share.png" />
          </div>
          <!-- 피드메뉴 우측 아이콘 -->
          <div class="menu-icon-div">
            <img class="menu-right-icon" src="/img/mark.png" />
          </div>
        </div>
        <!-- 피드 댓글부분 -->
        <div class="feed-text">
          <!-- 좋아합니다 부분 -->
          <div class="like-text">
            <!-- 프로필이미지와 텍스트 -->
            <img class="text-img" src="/img/user.png" />
            <span class="nickname"
              >junyoung</span>님 외 <span class="font-bold">10명</span>이
              좋아합니다</span
            >
          </div>
          <!-- 피드설명 -->
          <div class="writing">
            <span class="nickname">cannon_mj</span>
            <span>위워크에서 진행한 우주선 클래스...</span>
            <span class="more-text">더 보기</span>
          </div>
          <!-- 댓글 창 -->
          <ul class="comment-ul">
            <li>
              <span class="nickname"> neceosecius </span>
              <span class="comment-text">거봐 좋았잖아~~~~🤷‍♀️</span>
            </li>
            <li>
              <span class="nickname"> neceosecius </span>
              <span class="comment-text">거봐 좋았잖아~~~~🤷‍♀️</span>
            </li>
          </ul>
          <!-- 시간표시 -->
          <div class="text-time">
            <span>42분 전</span>
          </div>
          <!-- 댓글인풋 -->
          <div class="comment-input-container">
            <div class="comment-input-width">
              <input
                class="comment-input"
                type="text"
                placeholder="댓글 달기..."
              />
            </div>
            <!-- 버튼인풋 -->
            <div class="comment-btn-container">
              <button class="comment-btn" disabled>게시</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
  <script type="text/javascript" src="/js/main.js"></script>
</html>