//提交结果查询
select submitstate.id, problem.id problemid,problem.title,user.name,state,codeType,memory,runtime,submitDate,codeLength
from submitstate,acceptcode,user,problem
where acceptcode.aid=submitstate.cid
and submitstate.state='rightAnswer'
and acceptcode.uid=user.id
and acceptcode.pid=problem.id
order by submitstate.id desc

//查看结果
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
 
 //查看所有的用户通过的题目
 SELECT user.name,problem.title
from user,acceptcode,problem
where user.id=acceptcode.uid and acceptcode.pid=problem.id
 //查看未通过的用户题目
 SELECT user.name,problem.title
from user,errocode,problem
where user.id=errocode.uid and errocode.pid=problem.id
 
//查看某个用户通过的信息
select pid,problem.title,passDate
from acceptcode,user,problem
where user.id=acceptcode.uid
  and problem.id=acceptcode.pid
  and user.name='citychen2008'