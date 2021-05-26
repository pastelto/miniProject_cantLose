package com.kh.project.reservation.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.Login;


public class MemberDao { // file로 으로 저장해서 파일 불러와서 내용 일치 확인<ID,PW>과 멤버 정보 저장

   private ArrayList<Account> list = new ArrayList<>();
   
   public MemberDao() { 
      
      try(ObjectInputStream ois = new ObjectInputStream (new FileInputStream("account.dat"))){
         list.addAll((ArrayList<Account>)ois.readObject());
         
      }catch(ClassNotFoundException e) {
         System.out.println("파일을 찾을 수 없습니다.1");
      }catch(FileNotFoundException e) {
         System.out.println("파일을 찾을 수 없습니다.2");
      }catch(IOException e) {
         System.out.println("파일을 찾을 수 없습니다.3");
      }
   }
   
   public void writeAccount(Account account) {
      list.add(account);
   }

   public void saveAccount() {
      try(ObjectOutputStream oos = new ObjectOutputStream
            (new FileOutputStream("account.dat"))){
         System.out.println(list);
         oos.writeObject(list);
                  
         System.out.println("account.dat에 성공적으로 저장되었습니다.");
         
      }catch(FileNotFoundException e) {
         System.out.println("파일을 찾을 수 없습니다.");
      }catch(IOException e) {
         System.out.println("파일을 찾을 수 없습니다.2");
      }
      
   }
   public ArrayList<Account> searchAccount(String id, String pw) {

      ArrayList<Account> check = new ArrayList<Account>();

      for (int i = 0; i < list.size(); i++) {
         if (list.get(i).getId().equals(id)&&list.get(i).getPw().equals(pw)) {
            check.add(list.get(i));
            System.out.println(list.get(i));
         } 
      }
      System.out.println(check);
      return check;
   }

   public Boolean CheckId(String id) { //아이디 중복 체크
   
      for(int i =0; i<list.size();i++) {
         if(list.get(i).getId().equals(id)) {
         return true;
         }
      }
      return false;
      }

   
   public Boolean CheckIdNum(String idNum) {//주민번호 중복 체크
      for(int i =0; i<list.size();i++) {
         if(list.get(i).getIdNum().equals(idNum)) {
         return true;
         } 
         
      }
      return false;
      }


   public void reSaveAccount(Account account) { // 로그아웃하면서 정보갱신
      try(ObjectOutputStream oos = new ObjectOutputStream
            (new FileOutputStream("account.dat"))){
         
         for(int i = 0; i < list.size(); i++) {
         if(list.get(i).getId().toString().equals(account.getId())){
            list.remove(list.get(i));
            list.add(account);
            System.out.println(list);
            System.out.println("성공적으로 로그아웃이 되었습니다.");
            
         }   
         }   
         // list에 변경사항 저장
         oos.writeObject(list);
         System.out.println(list);
         
      }catch(FileNotFoundException e) {
         System.out.println("파일을 찾을 수 없습니다.");
      }catch(IOException e) {
         System.out.println("파일을 찾을 수 없습니다.2");
      }
      
   }
      
   

   public ArrayList<Account> Find(String name,String idNum) {
      ArrayList<Account> find = new ArrayList<>();
      for(int i =0; i<list.size();i++) {
         System.out.println(list.get(i));
         if((list.get(i).getName()).equals(name)&&(list.get(i).getIdNum()).equals(idNum)) {
            find.add(list.get(i));
            System.out.println(find);
         return find;
         } 
      }
      System.out.println(find);
      return find;
      } 
   

      }


   
   