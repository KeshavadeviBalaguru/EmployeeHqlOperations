package com.java;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainApp {

	public static void main(String[] args) {

		Configuration con= new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(MainApp.class);
		 ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		 SessionFactory factory= con.buildSessionFactory(reg);
		 Session session= factory.openSession();
		 Transaction t= session.beginTransaction();
		/*
		Employee e=new Employee(1, "AAA", 34567, "Pondy", 101);
		session.save(e);
		 
		Employee e1=new Employee(2, "BBB", 20000, "KKl", 102);
		session.save(e1);
		 
		Employee e2=new Employee(3, "CCC", 34000, "Chennai", 103);
		session.save(e2);
		 
		Employee e3=new Employee(4, "DDD", 25000, "Pondicherry", 104);
		session.save(e3);
		t.commit();
		*/
		 
		 //get record based on id
		 
		 //Employee r=(Employee) session.get(Employee.class, 1);
		 /*Employee r= (Employee) session.get(Employee.class, 2);
		 
		 System.out.println(r);
		 
		 //System.out.println();
		// System.out.println("eid="+r.getEid()+"name ="+r.getName()+"Salary = "+r.getSalary()+"Address = "+r.getAddress()+"deptno = "+r.getDeptno());
		
		 t.commit();
		 session.close(); 
		 */
		 
		/*//Retrieve all records
			Query q=session.createQuery("from Employee");  //select * from tablename
			 
			//from nameoftheclass
	              
	           List l=q.list();  
	           System.out.println(l);
	           Iterator<Employee> it=l.iterator();
	           while(it.hasNext()) {
	        	 Employee r=it.next();
	        	 System.out.println("emp id="+r.getEid()+" name="+r.getName()+" Salary="+r.getSalary()+" address="+r.getAddress()+" deptno="+r.getDeptno());
	           }
	           t.commit();
	  		 session.close(); 
		 
		*/
		 
		/*//update record
			Query q=session.createQuery("update Employee set name=:n where eid=:i");
			q.setParameter("n", "Anitha");
			q.setParameter("i", 1);
			
			int i=q.executeUpdate();
			if(i>0) {
				System.out.println("Record is updated");
			}
			else {
				 System.out.println("Not updated");
			}

			t.commit();
	  		 session.close(); */
		 
		 //delete record
		 
		/* Query d=session.createQuery("delete from Employee  where eid=:i");
			d.setParameter("i", 4);
			
			int i=d.executeUpdate();
			if(i>0) {
				System.out.println("Record is deleted");
			}
			else {
				 System.out.println("Not updated");
			}

			t.commit();
	  		 session.close();
		 */
		 
		 //Aggregate Funtion
		 
		/* Query s=session.createQuery("select sum(salary) from Employee");
		 List st=s.list();
		 System.out.println("Total Salary = "+st.get(0));
		 
		 t.commit();
  		 session.close();
         */
  		 
  		 /*Query s=session.createQuery("select avg(salary) from Employee");
		 List st=s.list();
		 System.out.println("Average Salary = "+st.get(0));
		 
		 t.commit();
  		 session.close();
         */
		 
		 Query s=session.createQuery("select min(salary) from Employee");
		 List st=s.list();
		 System.out.println(" Minimum Salary = "+st.get(0));
		 
		 Query s1=session.createQuery("select count(eid) from Employee");
		 List st1=s1.list();
		 System.out.println(" NUmber of Employee= "+st1.get(0));
		 
		 t.commit();
  		 session.close();
         
	}

}
