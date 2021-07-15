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


### 5시간 넘게 걸린 파이어베이스 연동
- jcenter를 지워라 이게 젤 빠르다(안드로이드 스튜디오 버전 4 넘고 뭔 에러있나봄)
- tools에 잇는 파베 탭으로 연동하자 이게 젤 덜 귀찮더라 (아직 차이점 모름)
- realtime과 파이어스토어 차이를 모르겠다 setValue하면 리얼타임은 값만 바뀌고 파이어스토어는 값이 추가되더라
- 별 그지같은 에러가 항상 많다 공식문서를 항상 주목하자 그래도 안될때 스택오버플로우서 검색을 해서 에러를 찾아보자.
