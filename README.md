# SpringBoot-JPA-Blog
Git-> 프로젝트 관리

작업영역 - 인덱스(Index) - 헤드(HEAD)


위 세가지를 일치시키는 것(동기화)이 Git을 관리하는 것


작업영역 --add--> 인덱스 --commit--> 헤드


Http1.1 이란?


        http 통신 = 약속
        
        
       Byte Stream(8bit)
       
       
A<---------Write---------->B(서버)


A<---------Read----------->B(서버)


- 요청이 진행된 후 연결을 끊는다.


- 요청시마다(필요시) 스트림을 연결해서 Data를 주고 받는 방식


- 세션을 유지할 수 있는 방법이 없다



StateFul방식 => 계속 연결되어 있는 방식 ex)채팅


-> 세션이 만들어진다 == 데이터를 응답할 준비가 됨(계속 인증이 되어 있는 상태)


Http 통신방법 4가지(Request)


1. Get      - Request Data: Select 


2. Post     - Add Data: Insert        


3. Put      - Update Data: Update


4. Delete   - Delete Data: Delete


Post요청 ---- Header + Body ----> 서버


           헤더:Explain        - 데이터를 설명
           
           
           바디:realData.jpg   - 실제 데이터
           
           
           
Http 통신


1.패킷 스위칭 방식


  A ---------> B
  
  
  패킷 a,b,c,d 전송
  
  
  C ---------> B
  
  
  패킷 e,f,g 전송
  
  
데이터가 섞여서 전송될 수 있기 때문에 B가 조립을 해야한다. -> 조립을 위한 설명이 헤더에 저장되어 있음 


ex) a,b,c,d, // e,f,g


2.서킷 스위칭 방식


  A ---------> B
  
  
  데이터 [a,b,c,d]
  
  
  C ---------> B
  
  
  데이터를 한번에 Mapping하여 전송 
  
  
  빠르지만 비용이 크다
  
  
  
MiME타입-> 문서를 올바르게 전당하기 위해 필요.


일반적인 구조: type/subtype 


개별 타입: text/plain or text/html or image/jpeg ... 등등 


*참조 https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types


application.yml 설정


*참조 https://getinthere.tistory.com/20


영속성 컨텍스트


요청 ----> Controller -----> 응답 (Insert, Update, Delete, Select)


JAP(영속성 컨텍스트)


Insert---> 1차캐시(객체가쌓임) ---flush---> 객체를 DB에 전달


flush == DB에 저장하지만 1차캐시의 객체는 저장되어 있음


1차 캐시에 있는 객체 == 영속화 되었다.


select문 실행시 영속화되어있는지 확인 -> 영속화 되어있다면 바로 DB에 접근하지 않고 바로 전달


update문 실행시 DB에서 데이터를 가져온뒤 영속화 시킨다 -> 해당 영속화된 오브젝트의 값을 변경 -> 변경 후 save를 호출 -> 영속화 되어있는 데이터를 update -> DB에 flush ->완료


---------------------------------


Get요청 -> HttpBody로 데이터를 담아 보내지 않음


Post,Put,Delete(데이터 변경) 요청  -> 데이터를 담아 보내야 할 것이 많음..


Form 태그 ->method가 get,post 요청뿐


put,delete의 경우 자바스크립트로 요청을 해야함 ==> 자바스크립트로 AJAX요청, 데이터는 JSON으로 통일


form:form 태그 -> post,put,delete,get요청 모두 가능함


오브젝트로 데이터받기..


데이터 전송시 AJAX방식을 사용하는 2가지 이유..


1. 요청에 대한 응답을 HTML이 아닌 DATA(JSON)를 받기 위해..


== 클라이언트(브라우저)---요청--->서버---응답(html)---> 클라이언트(브라우저)


*클라이언트가 항상 브라우저를 사용하진 않음!-> 서버가 응답을 해줄때 Data를 전달(정상이라는 응답) -> 메인페이지로만 요청


AJAX통신 


브라우저---->요청----->서버----->정상---->브라우저----->메인페이지 요청------>메인페이지


앱----->요청----->서버----->정상---->앱내부에서 화면이동


2. 비동기 통신을 하기 위해..


비동기 통신이란..? 절차적으로 일을 처리하되, 순서에 상관없이 일처리..



@Service


1. 트랜잭션 관리


트랜잭션 : 일이 처리되기 위한 가장작은 단위 

트랜잭션+트랜잭션 = 하나의 트랜잭션 가능 == spring에서는 이걸 service라고 부름


2. 서비스의 의미 -> 하나의 완성된 기능


-- CSRF, XSS

XSS-> 자바스크리브 공격 -> 단순한 서버 과부화공격 -> 스크립트문 못적게 막아두면된다.

CSRF-> 관리자의 계정으로 접속시 http://naver.com/admin/point?id=?&point=50000" -> 실행시 관리자 권한탈취가능 => 하이퍼링크 즉 GET방식의 공격

방어방법 -> Referrer검증 / CSRF Token 사용 ->로그인시 CSRF토큰을 생성하여 세션에 저장 -> 요청페이지에 토큰을 세팅하여 전송
