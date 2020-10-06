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




