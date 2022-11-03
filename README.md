## 실행 방법

1. jdk 설치
2. git clone ```git clone https://github.com/hacathon-app/backend.git```
3. 터미널에서 클론한 프로젝트에 접근 후 ```./gradlew run``` 실행

## 기능 명세
[postman API 문서 링크](https://documenter.getpostman.com/view/18173897/2s8YRqkqRE)

## 전체적인 흐름

회원가입/로그인
1. 이름과 비밀번호를 입력해 회원가입을 할 수 있음
2. 비밀번호는 암호화시켜서 자동으로 보관함
3. 일반 유저 계정과 관리자 계정이 나뉘어져 있음

유저 계정으로 로그인 시
1. 근태 정보 화면으로 넘어감
2. 출근버튼을 누르면 상태가 출근중으로 바뀌고 타이머가 돌아감
3. 12시부터 1시까지는 스케쥴링으로 상태를 휴식중으로 바꾸고, 타이머를 멈춤
4. 현재 근무중인 다른 회원들을 조회할 수 있음
5. 현재 근무중이지 않은 회원들을 조회할 수 있음
6. 퇴근 버튼을 누르면 타이머가 종료되고 유저의 통계에 저장됨

관리자 계정으로 로그인 시
1. 유저와 똑같이 현재 근무중인, 근무중이지 않은 회원들을 볼 수 있음
2. 유저를 클릭하면 해당 유저의 상세정보가 뜸
- 상세정보 :
- 현재 위치
- 이름
- 출퇴근 상태
- 지금까지 일한 시간
- 남은 시간
3. 회원의 이름을 수정할 수 있음