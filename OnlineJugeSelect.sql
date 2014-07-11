//�ύ�����ѯ
select submitstate.id, problem.id problemid,problem.title,user.name,state,codeType,memory,runtime,submitDate,codeLength
from submitstate,acceptcode,user,problem
where acceptcode.aid=submitstate.cid
and submitstate.state='rightAnswer'
and acceptcode.uid=user.id
and acceptcode.pid=problem.id
order by submitstate.id desc

//�鿴���
select submitstate.id submitId, problem.id problemId,problem.title,user.name,state,codeType,memory,runtime,submitDate,codeLength
from submitstate,acceptcode,user,problem,errocode
where
  (
   acceptcode.uid=user.id
  and acceptcode.aid=submitstate.cid
  and submitstate.state='rightAnswer'
  and acceptcode.pid=problem.id
  )
or (
    errocode.uid=user.id
    and submitstate.state<>'rightAnswer'
    and errocode.eid=submitstate.cid
    and errocode.pid=problem.id
   )

 group by submitstate.id order by submitstate.submitDate desc
 
 //�鿴���е��û�ͨ������Ŀ
 SELECT user.name,problem.title
from user,acceptcode,problem
where user.id=acceptcode.uid and acceptcode.pid=problem.id
 //�鿴δͨ�����û���Ŀ
 SELECT user.name,problem.title
from user,errocode,problem
where user.id=errocode.uid and errocode.pid=problem.id
 
//�鿴ĳ���û�ͨ������Ϣ
select pid,problem.title,passDate
from acceptcode,user,problem
where user.id=acceptcode.uid
  and problem.id=acceptcode.pid
  and user.name='citychen2008'