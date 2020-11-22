package com.example.spring_boot_introduction_model.chapter5.repositories;

import com.example.spring_boot_introduction_model.chapter5.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MyDataRepository04 extends JpaRepository<MyData, Long> {
    public MyData findByid(Long name);  // 왜인지 모르겠는데 Id로 하면 오류뜨고 id 해야함 (MyData의 id와 무관)
}
