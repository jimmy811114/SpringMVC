package web.entity;
// Generated 2017/9/8 上午 11:40:03 by Hibernate Tools 4.3.1



/**
 * Member generated by hbm2java
 */
public class Member  implements java.io.Serializable {


     private String member;
     private String pwd;

    public Member() {
    }

	
    public Member(String member) {
        this.member = member;
    }
    public Member(String member, String pwd) {
       this.member = member;
       this.pwd = pwd;
    }
   
    public String getMember() {
        return this.member;
    }
    
    public void setMember(String member) {
        this.member = member;
    }
    public String getPwd() {
        return this.pwd;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }




}


