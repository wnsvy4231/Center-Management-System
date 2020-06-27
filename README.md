# Center-Management-System

<center><img src="https://yt3.ggpht.com/a/AGF-l78Py23XN9BqkJm2vB5bJs42Bkn82KSYicxCSg=s900-c-k-c0xffffffff-no-rj-mo" width="500px" height="500px"></center>
 <style>
        /* 
            웹 폰트, Web Font
            1. 예전 방식
                - *.eof
            2. CSS3 웹 폰트 
                - 서버로부터 폰트를 다운받아 현재 사이트 접속 중에만 임시로 사용 
         */
         /* 웹 폰트 선언 */
        @font-face {
            font-family: 'BM'; /*내가 정의하는 폰트명*/
            src: url(../images/BMJUA_ttf.ttf)
        }
        @font-face { font-family: 'MapoDPPA'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/MapoDPPA.woff') format('woff'); font-weight: normal; font-style: normal; }
        /* 한글은 눈누 영어: 구글 웹폰트 */
        body{
            /* font-family: 'BM'; */
            /* font-family: 'Cute Font', cursive; */
            font-family: 'MapoDPPA';
        }
    </style>
    <link href="https://fonts.googleapis.com/css2?family=Cute+Font&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/MapoDPPA.woff'" rel="stylesheet">
        
### 👋 Introduction
<body>
<table>
    <tr>
        <th>프로젝트 명 </th>
        <th>Membership management program</th>
        <th>개발기간</th>
        <th>2020.05.13. ~ 2020.05.19.</th>
    </tr>
    <tr>
        <th>프로젝트 성격</th>
        <th>JAVA 콘솔 프로젝트</th>
        <th>개발인원</th>
        <th>팀 / 5명<br>
            (<a href="https://github.com/prohwww">한시연</a>｜홍준표｜장정우｜유민정｜최현동 )
        </th>
    </tr>
    <tr>
        <th>프로젝트 개요</th>
        <th>회원 관리 프로그램</th>
        <th>개발환경&nbsp;</th>
        <th>Windows10</th>
    </tr>
    <tr>
        <th colspan="5">사용 도구</th>
    </tr>
    <tr>
        <th>개발언어</th>
        <th colspan="3">Java(JDK 1.8) </th>
    </tr>
    <tr>
        <th>형상관리</th>
        <th colspan="3">Github, Git , Source Tree</th>
    </tr>
    <tr>
        <th>개발도구</th>
        <th colspan="3">Eclipse IDE</th>
    </tr>
</table>

### 📼 Appearance
콘솔로 구현한 회원 관리 시스템 입니다.

<table>
    <tr>
        <th colspan="4">Task</th>
    </tr>
    <tr>
        <th colspan="4"><img width="600"
                src="https://user-images.githubusercontent.com/66079830/85919690-a5914900-b8a8-11ea-9849-4d3ca500813f.jpg">
        </th>
    </tr>
    <tr>
        <th>Admin</th>
        <th>Teacher</th>
        <th>Student</th>
        <th>Nonmember</th>
    </tr>
    <tr>
        <th><img width="266"
                src="https://user-images.githubusercontent.com/66079830/85919479-5d712700-b8a6-11ea-9043-8ddb87532e19.gif">
        </th>
        <th><img width="266"
                src="https://user-images.githubusercontent.com/66079830/85919538-e5efc780-b8a6-11ea-8422-4c1a38a741e0.gif">
        </th>
        <th><img width="266"
                src="https://user-images.githubusercontent.com/66079830/85919534-d7091500-b8a6-11ea-85b3-149d091c8e5d.gif">
        </th>
        <th><img width="266"
                src="https://user-images.githubusercontent.com/66079830/85919534-d7091500-b8a6-11ea-85b3-149d091c8e5d.gif">
        </th>
    </tr>
</table>

### 📑 Role & Member
<table>
    <tr>
        <th width="16%">업무 / 구성원</th>
        <th width="14%">한시연</th>
        <th width="14%">홍준표</th>
        <th width="14%">장정우</th>
        <th width="14%">유민정</th>
        <th width="14%">최현동</th>
    </tr>
    <tr>
        <th>프로젝트 기획</th>
        <th colspan="5">문서작성,회의, 의견제안</th>
    </tr>
    <tr>
        <th>요구분석</th>
        <th colspan="5">문서작성,회의, 의견제안</th>
    </tr>
    <tr>
        <th>데이터설계</th>
        <th colspan="5">문서작성,회의, 의견제안</th>
    </tr>
    <tr>
        <th>기능명세서</th>
        <th colspan="5">문서작성,회의, 의견제안</th>
    </tr>
    <tr>
        <th>화면설계</th>
        <th>관리자,수강생</th>
        <th>수강생,관리자</th>
        <th>비회원,통합</th>
        <th>관리자,선생님</th>
        <th>관리자,선생님</th>
    <tr>
        <th>소스(코딩)</th>
        <th>관리자,<br> 수강생,<br> 비회원 1:1문의 기능,<br> 강사모드(전체),<br> 관리자(강사관리),<br> 더미 파일 작성(강사)</th>
        <th>비회원,<br> 관리자 수강추천,<br>기자재관리,<br> 성적(강사모드),<br>첫 메인화면,<br>회원가입 더미파일 작성</th>
        <th>비회원,<br>관리자,<br>수강생 교육과정 조회,<br>수강생 관리,<br>수강생 모드,<br>수강생 더미 파일(전체)</th>
        <th>첫 메인화면,<br>회원 가입,<br> 로그인,<br>수강생 더미파일 작성</th>
        <th>관리자 수업관리,<br> 코드 종합,<br> 교과과목 더미파일 작성</th>
    </tr>
    <tr>
        <th>의견제안, 화면캡쳐</th>
        <th>의견제안, 화면캡쳐</th>
        <th>의견제안, 화면캡쳐</th>
        <th>발표 보조, 발표자료, 의견제안, 화면캡쳐</th>
        <th>의견제안, 화면캡쳐</th>
        <th>발표, 총괄, 화면캡쳐</th>
    </tr>
    <tr>
        <th>역할</th>
        <th>관리자,<br>수강생,<br>비회원 부분 개발,<br>버그수정,<br>의견제안,<br>문서작업</th>
        <th>비회원,<br> 관리자 부분 개발,<br> 문서작업,<br> 의견제안,<br> 버그수정</th>
        <th>비회원,<br>관리자,<br>수강생 부분 개발,<br> 문서작업,<br> 의견제안</th>
        <th>회원 가입 부분 개발,<br> 문서작업,<br> 소스취합,<br> 버그수정</th>
        <th>관리자 부분 개발,<br> 의견제안,<br> 버그수정</th>
    </tr>
</table>
</body>
