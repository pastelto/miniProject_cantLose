package com.kh.project.reservation.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.kh.project.reservation.controller.CheckAccount;
import com.kh.project.reservation.controller.DrinkManager;
import com.kh.project.reservation.controller.InOutManager;
import com.kh.project.reservation.controller.PrintServiceManager;
import com.kh.project.reservation.controller.ReservationManager;
import com.kh.project.reservation.controller.TicketManager;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.pay.Drink;
import com.kh.project.reservation.model.vo.pay.Print;

public class appMenu {

   Scanner sc = new Scanner(System.in);

   ReservationManager rm = new ReservationManager();
   TicketManager tm = new TicketManager();

   DrinkManager dm = new DrinkManager();
   InOutManager io = new InOutManager();
   Drink d = new Drink();
   Account a = new Account();

   CheckAccount ca = new CheckAccount();

   HashMap<String, Account> membership = new HashMap<>();

   // 로그인 창
   public void login() {
      while (true) {

         System.out.println("로그인");
         String id = sc.nextLine().trim();

         System.out.println("비밀번호");
         String pw = sc.nextLine().trim();

         // if(rm.checkIdNPw() 가 맞는지 체크 맞으면 메뉴 페이지, 아니면 팝업창도록 수정
         ca.checkId(id);
         if (membership.containsKey(id) && (membership.get(id).getPw()).equals(pw)) {
            System.out.println("로그인 완료");

            break;
         } else {
            System.out.println("아이디, 비밀번호가 일치 하지 않습니다.");
            continue;
         }
      }
   }

   // 회원가입 창 - 회원가입 버튼 클릭시 추가
   public void singIn() {
      while (true) {
         
         System.out.println("로그인");
         String id = sc.nextLine();

         System.out.println("비밀번호");
         String pw = sc.nextLine();

         System.out.println("이름");
         String name = sc.nextLine();

         System.out.println("주민번호");
         String idNum = sc.nextLine();

         System.out.println("성별");
         char gender = sc.nextLine().charAt(0);

         System.out.println("핸드폰 번호");
         String pNum = sc.nextLine();

         System.out.println("은행");
         String bank = sc.nextLine();

         System.out.println("카드번호");
         String pay = sc.nextLine();

         int coupon = 1;

         // if()문으로 일치 확인
         if (membership.containsKey(id)) {
            System.out.println("해당 아이디는 사용이 불가능합니다.");
         } else if ((membership.get(id).getIdNum()).equals(idNum)) {
            System.out.println("이미 회원가입된 회원입니다.");
         } else {
            ca.addSingIn(addAccount(id, pw, name, idNum, gender, pNum, bank, coupon));
         }
      }
   }
   
   // 계정추가 (회원가입완료)
   private Account addAccount(String id, String pw, String name, String idNum, char gender, String pNum, String bank, int coupon) {
      return new Account();
   }

   // 로그인 후 메뉴
   private void menu() {
      while (true) { // 나중에 GUI랑 연결 // true값 대신 로그인 조건 받아와야할듯..?

         System.out.println("******* MENU *******");
         System.out.println("메뉴를 선택해주세요");
         int num = sc.nextInt();
         sc.nextLine();

         switch (num) {

         case 1: // 예약
            //BookView();
            break;
         case 2: // 이용권 구매
            buyTicket();
            break;
         case 3: // 음료 구매
            dm.orderBeverage();
            break;
         case 4: // 프린트 서비스
            printService();
            break;
         case 5: // 예약정보 확인
            rm.checkMyReservation();
            // (2) 현재 예약 정보 없으면 null -> 예약하기 case 2로 연결
            break;
         case 6: // 내정보
            break;
         case 7: // 체크인 / 체크아웃
            checkInOutM();
            break;
         case 8: // 로그아웃
            return; // 또는 초기화면 이동

         }

      }

   }

   // 체크인&체크아웃 메뉴
   private void checkInOutM() {
         ArrayList ss = io.checkInSave();
         
         if (ss.get(3).equals("")) {// 체크인 안했을 때 
            while (true) {
               System.out.println("체크인 또는 체크아웃 또는 이전을 입력하세요");
               String str = sc.nextLine();
               if (str.equals("체크인")) {
                  checkIn(); // 체크인 메소드
                  break;
               } else if (str.equals("체크아웃")) {
                  System.out.println("체크인 한 기록이 없습니다. 메인 화면으로 돌아갑니다.  ");
                  break;
               } else if (str.equals("이전")) {
                  System.out.println("메인메뉴로 돌아갑니다.");
               }
            }
         } else if (ss.get(3).equals("체크인")) {// 체크인 한 버전 // 상태 확인
            io.chechkedIn();
            String str = sc.nextLine();
            if (str.equals("체크아웃")) {
               checkOut(); // 체크아웃 메소드
            }else if (str.equals("이전")) {
               System.out.println("메인메뉴로 돌아갑니다.");
            }
         } else { 
            System.out.println("체크아웃하여 재입실이 불가합니다." + " \n" + "메인 화면으로 돌아갑니다.");
         }
      }
      

   
   // 체크인 
   private void checkIn() {
      io.checkInSave();

      System.out.println("체크인 하시겠습니까? (Y/N)");
      String str = sc.nextLine();

      if (str.equals("Y") || str.equals("y")) {
         io.checkInPrint();
         System.out.println("체크인 되었습니다.");
      } else if (str.equals("N") || str.equals("n")) {
         System.out.println("메인 메뉴로 돌아갑니다. ");
      }

   }

   // 체크아웃
   private void checkOut() {
      System.out.println("체크아웃 시 재입실이 불가합니다." + "체크아웃 하시겠습니까? (Y/N)");
      String str = sc.nextLine();

      if (str.equals("Y") || str.equals("y")) {
         io.checkOutPrint();
         System.out.println("체크아웃 되었습니다." + "\n" + "고생하셨습니다 :) ");
      } else if (str.equals("N") || str.equals("n")) {
         System.out.println("메인 메뉴로 돌아갑니다. ");
      }
   }

   // 프린트 서비스
   private void printService() {
      Print p = new Print();
      PrintServiceManager psm = new PrintServiceManager();
      while (true) {
         System.out.println("***프린트 서비스***");
         System.out.println("1. 프린트포인트 조회");
         System.out.println("2. 프린트포인트 충전");
         System.out.println("3. 프린트하기");
         System.out.println("4. mainMenu");

         System.out.println("메뉴선택: ");
         int num1 = sc.nextInt();
         sc.nextLine();

         switch (num1) {
         case 1:
            psm.prtPointInfo();
            break;
         case 2:
            System.out.println("충전금액: ");
            int num2 = sc.nextInt();
            sc.nextLine();
            psm.prtPointCharge(num2);
            System.out.println("충전완료. : " + p.getPrintPoint());
            break;
         case 3:
            System.out.println("흑백 매수: ");
            int b = sc.nextInt();
            System.out.println("컬러 매수: ");
            int c = sc.nextInt();
            sc.nextLine();
            psm.prtPointUse(b, c);
            break;
         case 4:
            menu();
            break;
         default:
            System.out.println("다시 입력해주세요.");
            break;
         }
      }
   }

   // 이용권 구매
   private void buyTicket() {
      while (true) {
         System.out.println("***이용권 구매***");
         System.out.println("1. 1인좌석");
         System.out.println("2. 스터디룸");
         int num = sc.nextInt();
         sc.nextLine();
         int num1 = 0;

         switch (num) {
         case 1: // 기간에 따른 할인률 적용하여 반환
            System.out.println("***기간 선택***");
            System.out.println("1. 1 일권 ");
            System.out.println("2. 1 개월권 ");
            System.out.println("3. 6 개월권 ");
            System.out.println("4. 1 년권 ");
            int option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {
               System.out.println("수량 : ");
               num1 = sc.nextInt();
               tm.onePrice(option, num1);
               tm.addCntTicket(num1);
               System.out.println("총 금액은 " + tm.onePrice(option, num1) + " 입니다.");
               break;
            } else {
               tm.onePrice(option);
               System.out.println("총 금액은 " + tm.onePrice(option) + " 입니다.");
               break;
            }

         case 2: // 스터디룸은 수량만 확인해서 반환
            System.out.println("수량 : ");
            int num2 = sc.nextInt();
            sc.nextLine();
            System.out.println("총 금액은 " + tm.strPrice(num2) + "입니다.");
            break;
         default:
            System.out.println("다시입력해주세요.");
            break;
         }
         menu();
      }
   }

   // 예약정보 
   private void checkMyReservation() {

      System.out.println("***예약 정보 확인***");

      String myR = rm.checkMyReservation();
      if (myR == null) {

         System.out.println("예약정보가 없습니다." + "\n" + "새롭게 예약을 하시겠습니까?" + "\n" + "(수락시 예약화면으로 넘어갑니다.");

         System.out.println("예약정보가 없습니다." + "\n" + "새롭게 예약을 하시겠습니까?" + "\n" + "(수락시 예약화면으로 넘어갑니다.)");

         // 예약화면으로 연결
      } else {
         // 예약정보 가져오기

      }

      while (true) {

         System.out.println("*** 예약 변경 메뉴 ***");
         System.out.println("1. 예약변경");
         System.out.println("2. 예약취소");

         int click = sc.nextInt();
         // 버튼 클릭

         switch (click) {
         case 1:
            rm.changeReservation();
            break;
         case 2:
            rm.cancelReservation();
            break;
         case 3:
            menu();
            break;

            // 예약정보 창

            }

         }
      }
   }