package com.framework.seata.storage.repository;

import com.framework.seata.storage.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Description：
 *
 * @author fangliangsheng
 * @date 2019-04-04
 */
public interface StorageDAO extends JpaRepository<Storage, String> {

    Storage findByCommodityCode(String commodityCode);

}
