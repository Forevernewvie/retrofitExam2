# retrofitExam2
레트로핏연습 + 파베 연동


<Img src="https://user-images.githubusercontent.com/53516129/125808106-8fcf7498-1f11-4ac3-9774-e9e46258fa25.JPG" />




### - 3시간을 헤맨점
- 모든 코드가 완벽하게 작동했지만
- 영화진흥원 사이트 api가 https가 아니라 http라
-CLEARTEXT communication to www.kobis.or.kr not permitted by network security policy라는 에러가 떴다 이것 때문에 연결자체가 안됐다. 내가 이걸 log로 확인을 안해가지고 한참 헤맸다
 가장 빠른 해결법은 매니페스트에 android:usesCleartextTraffic="true"를 추가해주는것이다.

- 그리고 socket failed: eperm (operation not permitted) 이거 
- 예뮬에서 실험할거면 uses-permission android:name="android.permission.INTERNET 이 퍼미션 넣기전에 앱을 실행 시켰다면
- 앱을 삭제하고 다시 실행해야 적용된다 잊지말자!



<br>

### 파이어베이스 연동 제거
- MVP + KOIN으로 코드 리팩토링
