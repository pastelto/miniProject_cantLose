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

	public MemoDao(Account account) {
		
		String fileName = account.getId().toString() + ".dat";
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

			memoList.addAll((ArrayList<Memo>)ois.readObject());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("메모를 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("메모 리스트 읽기 완료");
		}	
	}

	public int getLastMemoNo() {

		return memoList.get(memoList.size() - 1).getMemoNo(); // size보다 1작은 수가 마지막 번호 cf. 배열길이

	}
	
	public void writeMemo(Memo memo) {

		memoList.add(memo);

	}

	// 메모 저장
	public void saveMemo(Account account) {
		String fileName = account.getId().toString() + ".dat";
		try(ObjectOutputStream oos = new ObjectOutputStream
				(new FileOutputStream(fileName))){
			
			oos.writeObject(memoList);
						
			System.out.println(fileName + "에 성공적으로 저장되었습니다.");
			
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(IOException e) {
			System.out.println("파일을 찾을 수 없습니다.2");
		}
		
	}
	public Memo displayBoard(int no) {
		Memo b = null; // 번호에 맞는 내용이 저장
		for (int i = 0; i < memoList.size(); i++) {
			if (memoList.get(i).getMemoNo() == no) {

				b = memoList.get(i);
				break;

			}

		}
		return b;
	}


	// 메모 제목 수정
	public void editMemo(String title, String memo, String time) { 

		for (int i = 0; i < memoList.size(); i++) {
			if (memoList.get(i).getMemoNo() == no) {
				memoList.get(i).setTitle(title);
				memoList.get(i).setMemo(memo);
				memoList.get(i).setTime(time);
				break;
			}
		}

	}


	public void deleteBoard(int no) {

		for (int i = 0; i < memoList.size(); i++) {
			if (memoList.get(i).getMemoNo() == no) {
				memoList.remove(i);
				break;

			}
		}

	}


	public void saveListFile(Account account) {
		String fileName = account.getId().toString() + ".dat";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) { // true 삭제!!

			oos.writeObject(memoList);
			System.out.println(memoList);

			System.out.println(fileName + ".dat에 성공적으로 저장되었습니다.");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
