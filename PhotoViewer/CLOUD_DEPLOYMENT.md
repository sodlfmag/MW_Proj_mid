# Android 앱 클라우드 서버 연동 가이드

## PythonAnywhere 서버 연동

### Step 1: MainActivity.java 수정

**`PhotoViewer/app/src/main/java/com/example/helloandroid/MainActivity.java`에서:**

```java
// 로컬/에뮬레이터: http://10.0.2.2:8000
// 클라우드: https://<your-username>.pythonanywhere.com
String site_url = "https://<your-username>.pythonanywhere.com";
```

**`<your-username>`을 자신의 PythonAnywhere 사용자명으로 변경하세요!**

### Step 2: 네트워크 보안 설정 확인

**`res/xml/network_security_config.xml`이 이미 설정되어 있지만, HTTPS를 사용하므로 확인:**

```xml
<?xml version="1.0" encoding="utf-8"?>
<network-security-config>
    <base-config cleartextTrafficPermitted="true">
        <trust-anchors>
            <certificates src="system" />
        </trust-anchors>
    </base-config>
</network-security-config>
```

HTTPS를 사용하므로 시스템 인증서를 신뢰하면 됩니다.

### Step 3: 앱 재빌드 및 테스트

1. **Android Studio에서 프로젝트 동기화** (Gradle Sync)
2. **앱 재빌드** (Build → Rebuild Project)
3. **실제 기기 또는 에뮬레이터에 설치**
4. **앱 실행**
5. **"동기화" 버튼 클릭**
6. 클라우드 서버에서 이미지 다운로드 확인

## 로컬과 클라우드 전환 방법

### 조건부 URL 설정 (선택사항)

```java
// 빌드 타입에 따라 자동 전환
String site_url = BuildConfig.DEBUG
    ? "http://10.0.2.2:8000"  // 개발: 로컬
    : "https://<your-username>.pythonanywhere.com";  // 프로덕션: 클라우드
```

또는

```java
// 에뮬레이터 감지
String site_url = Build.FINGERPRINT.contains("generic") || Build.FINGERPRINT.startsWith("unknown")
    ? "http://10.0.2.2:8000"  // 에뮬레이터
    : "https://<your-username>.pythonanywhere.com";  // 실제 기기
```

### 수동 전환 (간단한 방법)

`MainActivity.java`에서 `site_url` 변수만 수정:

**로컬 테스트:**
```java
String site_url = "http://10.0.2.2:8000";
```

**클라우드 테스트:**
```java
String site_url = "https://<your-username>.pythonanywhere.com";
```

## 문제 해결

### 1. 연결 실패

- 인터넷 연결 확인
- PythonAnywhere 서버가 실행 중인지 확인
- URL에 `https://`가 포함되어 있는지 확인

### 2. 인증 오류 (401)

- 토큰이 유효한지 확인
- 클라우드 서버에서 새 토큰 발급 필요할 수 있음

### 3. 이미지가 표시되지 않음

- Media files 경로 확인
- PythonAnywhere Web 설정에서 Media files 매핑 확인

## 평가 항목 (12번)

**제출 요구사항:**
- Client 동기화 완료 화면 (클라우드 서버연동)
- Android 앱에서 "동기화" 버튼 클릭 후 이미지가 표시되는 화면 캡처

