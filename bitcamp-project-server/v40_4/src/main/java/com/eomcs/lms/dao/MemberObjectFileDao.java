package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberObjectFileDao extends AbstractObjectFileDao<Member> implements MemberDao {


  public MemberObjectFileDao(String filename) {
    super(filename);
  }

  @Override
  public int insert(Member Member) throws Exception {


    if (indexOf(Member.getNo()) > -1) { // 같은 번호의 회원이 있다면,
      return 0;
    }

    list.add(Member); // 새 회원을 등록한다.
    saveData();
    return 1;
  }

  @Override
  public List<Member> findAll() throws Exception {
    return list;
  }

  @Override
  public Member findByNo(int no) throws Exception {

    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  @Override
  public int update(Member Member) throws Exception {
    int index = indexOf(Member.getNo());
    if (index == -1) {
      return 0;
    }
    list.set(index, Member);
    saveData();
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return 0;
    }
    list.remove(index);
    saveData();
    return 1;
  }

  @Override
  protected <K> int indexOf(K key) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == (int) key) {
        return i;
      }
    }
    return -1;
  }
}
