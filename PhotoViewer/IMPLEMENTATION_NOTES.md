# PhotoViewer Android 앱 구현 완료

## 구현 완료 사항 (12p~23p)

### 1. 권한 및 보안 설정 (12p-13p)
- ✅ AndroidManifest.xml에 인터넷 및 저장소 권한 추가
- ✅ network_security_config.xml 생성 (cleartext traffic 허용)

### 2. 레이아웃 구현 (14p-15p)
- ✅ activity_main.xml: 동기화 버튼, 업로드 버튼, TextView, RecyclerView
- ✅ item_image.xml: RecyclerView 아이템 레이아웃

### 3. ImageAdapter 클래스 (16p-17p)
- ✅ RecyclerView를 위한 ImageAdapter 구현 완료

### 4. MainActivity 클래스 (18p-23p)

#### 다운로드 기능 (20p-23p)
- ✅ onClickDownload: 서버에서 게시물 목록 가져오기
- ✅ CloadImage AsyncTask: 
  - API에서 JSON 응답 파싱
  - 각 게시물의 이미지 URL 다운로드
  - RecyclerView에 이미지 목록 표시

#### 업로드 기능 (19p, Post에 따른 UI 제공)
- ✅ onClickUpload: 이미지 선택 Intent 실행
- ✅ onActivityResult: 선택한 이미지 처리
- ✅ showUploadDialog: 제목/내용 입력 다이얼로그 표시
- ✅ PutPost AsyncTask: Multipart/form-data로 서버에 업로드

### 5. 의존성 추가
- ✅ RecyclerView 라이브러리 추가
- ✅ build.gradle.kts 및 libs.versions.toml 업데이트

## 주요 기능

### 다운로드 (동기화)
1. "동기화" 버튼 클릭
2. 서버 API에서 게시물 목록 GET 요청
3. 각 게시물의 이미지 URL에서 이미지 다운로드
4. RecyclerView에 이미지 목록 표시

### 업로드 (새로운 이미지 게시)
1. "새로운 이미지 게시" 버튼 클릭
2. 이미지 선택 (갤러리에서 선택)
3. 다이얼로그에서 제목과 내용 입력
4. "업로드" 버튼 클릭하여 서버에 POST 요청
5. 업로드 완료 메시지 표시

## 주의사항

### 토큰 업데이트 필요
`MainActivity.java`의 다음 부분을 실제 발급받은 토큰으로 변경하세요:
```java
String token = "e79ef213eae997b907ae570486118e9486e51662"; // 실제 토큰으로 교체 필요
```

### 서버 URL
현재 `site_url = "http://10.0.2.2:8000"`로 설정되어 있습니다.
- Android 에뮬레이터: `10.0.2.2` 사용
- 실제 기기: `127.0.0.1` 또는 서버 IP 주소 사용

## 다음 단계 (24p~)

이제 24p부터는 테스트 단계로 넘어갑니다:
- Socket 서버를 이용한 Client Request Protocol 검증
- Server/Client 연동 테스트

