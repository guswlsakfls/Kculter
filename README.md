# 개발전 필수사항 
<br/><br/>
## 버전들을 맞춰주셔야 합니다.
<br/>

```
node - v15.14.0
npm - 7.7.6
jdk - 11
```
위 버전들로 맞춰주시면 될것 같습니다.

<br/><br/><br/>
## 브랜치를 만들어주셔야 합니다.
<br/>
일단 지금까지는 제가 master 로 코드를 올렸는데 각자 branch를 생성하여서 코딩 해주시길 바랍니다.

<br/><br/><br/>
## FrontEnd는 frontend/kculter 폴더내에서 작업해주시길 바랍니다.
<br/>
제가 FrontEnd는 frontend/kculter 폴더로 프로젝트를 생성하였기 때문에 해당 폴더에서 작업해주시면 됩니다.

<br/><br/><br/>
## FrontEnd 내에서 작업을 완료하시고 웹 서버에서 UI 확인해보고 싶으시다면 react/target 폴더내에 있는 .jar 파일을 실행시켜주세요.
<br/>
제가 spring boot 프로젝트와 react 프로젝트를 같이 빌드할수 있도록 연동 시켜놨습니다. 
<br/>
따라서 웹서버 내에서 페이지를 확인하고 싶으시다면 .jar 파일을 터미널에서 아래 코드 입력하셔서 프로젝트 파일을 실행시켜서 확인해보시면 <br/>될것 같습니다

```
java -jar jar파일명
```

위 방법으로 UI 확인이 느리다면 따로 리액트 프로젝트에서 UI 만드셔서 확인해보시면 될것 같아여!!

<br/><br/><br/>
## FrontEnd내에서만 간단하게 작업한걸 확인해보고 싶으시다면 ``` frontend/kculter ``` 안에서 npm start 를 해주세요
<br/>
간단하게 UI만 확인해보고싶으시다면 ``` fronend/kculter 에서 ``` npm start ``` 를 해주시면 됩니다.

<br/><br/><br/>
## 화면에서 아무것도 뜨지 않는다면 f12를 눌러서 console에 찍힌게 없는지 확인해 봅니다.
<br/>
화면 내에서 아무것도 뜨지 않는다면 f12 개발자 모드를 눌러서 console을 눌러보시면 무엇이 잘못되어있는지 에러 로그를 확인해보실수 있습니다.

