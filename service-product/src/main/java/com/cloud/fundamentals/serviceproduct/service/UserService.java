package com.cloud.fundamentals.serviceproduct.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cloud.fundamentals.serviceproduct.vo.UserVO;

@Service
public class UserService {
	public List<UserVO> userSearch() {
		UserVO user1 = new UserVO(1, "Shankar", "Panda");
		UserVO user2 = new UserVO(2, "Jyotirmayee", "Gocchikar");
		UserVO user3 = new UserVO(3, "Soujanya", "Talla");
		return new ArrayList<UserVO>(Arrays.asList(user1, user2, user3));
	}
}
