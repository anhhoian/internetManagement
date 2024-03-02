/**
     * @author AnhP2
     *
     * @date 2001_05_28
	 *
     */


package fa.training.springmvc.service;

import java.util.List;

import org.springframework.data.domain.Page;

import fa.training.springmvc.common.Info;


public interface ListAllInfoService {
	
	List<Info> listAllInfo(Integer page, Integer size);

	List<Info> selectAllInfor();
}
