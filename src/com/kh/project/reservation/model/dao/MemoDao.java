package com.kh.project.reservation.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.Memo;


public class MemoDao {

	/*
	 * private int boardNo; private String boardTitle; private String boardWriter;
	 * private Date boardDate; private String boardContent; private int readCount;
	 */

	ArrayList<Memo> memoList = new ArrayList<Memo>();

	public MemoDao() {
		
	}
	
	public MemoDao(Account account) {
		
		String fileName = account.getId().toString() + ".dat";
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

//			memoList.addAll((ArrayList<Memo>)ois.readObject());
			
			Memo b;
			while((b=(Memo)ois.readObject()) != null){
				memoList.add(b);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("메모를 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("메모 리스트 읽기 완료");
		}	
	}
	
	public void writeMemo(Account account, Memo memo) {

		memoList.add(memo);

	}

	// 메모 저장
	public void saveMemo(Account account, Memo memo) {
		String fileName = account.getId().toString() + ".dat";
		try(ObjectOutputStream oos = new ObjectOutputStream
				(new FileOutputStream(fileName))){
			System.out.println("memoList : " + memoList.toString());
			oos.writeObject(memoList);
			System.out.println("메모리스트 : " + memoList);
						
			System.out.println(fileName + "에 성공적으로 저장되었습니다.");
			
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(IOException e) {
			System.out.println("파일을 찾을 수 없습니다.2");
		}catch(NullPointerException e) {
			System.out.println("파일을 찾을 수 없습니다.3");
		}
		
	}

	public void editMemo(Account account, ArrayList<Memo> m) {
		String fileName = account.getId().toString() + ".dat";
		
		
		try {
	         new FileOutputStream(fileName).close();  //저장 되어 있던 파일 내용 다 지우기
	      } catch (FileNotFoundException e1) {
	         
	      } catch (IOException e1) {
	         
	      }
	
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName, true))){
			System.out.println("memoList : " + m.toString());
			
			oos.writeObject(m);
			System.out.println("메모리스트 : " + m);
						
			System.out.println(fileName + "에 성공적으로 저장되었습니다.");
			
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(IOException e) {
			System.out.println("파일을 찾을 수 없습니다.2");
		}catch(NullPointerException e) {
			System.out.println("파일을 찾을 수 없습니다.3");
		}
		
	}
	
	public void deleteMemo(Account account, Memo memo) {
		String fileName = account.getId().toString() + ".dat";
		try {
	         new FileOutputStream(fileName).close();  //저장 되어 있던 파일 내용 다 지우기
	      } catch (FileNotFoundException e1) {
	         
	      } catch (IOException e1) {
	         
	      }

	}

}
