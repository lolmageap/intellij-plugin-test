## plugin 개발을 테스트 하기 위한 project 입니다. 

## Spec
- Kotlin
- Gradle
- Java Swing
- JDK 17

## How to run
1. src/main/kotlin/com/example/test 경로에 Plugin Devkit Action 을 생성 시켜 줍니다.
2. 그러면 resources/META-INF 경로에 plugin.xml 파일에 action 을 등록 시켜 줍니다.
3. 그리고 main 경로에 class file 또한 생성이 됩니다.
4. class file 을 작성 후 gradle build 를 실행 시켜 줍니다.

## TODO
- [ ] Notepad Plugin 개발
- [ ] Ctrl + N -> 새 메모 열기
- [ ] Ctrl + M -> 기존 메모 리스트 열기
- [ ] 메모를 닫을 때는 닫기 버튼 or esc
- [ ] 항상 자동 저장
- [ ] Kotlin, Java Class file 에서 Bytecode 파일로 추출
- [ ] 날짜별 Compile error history 개발
