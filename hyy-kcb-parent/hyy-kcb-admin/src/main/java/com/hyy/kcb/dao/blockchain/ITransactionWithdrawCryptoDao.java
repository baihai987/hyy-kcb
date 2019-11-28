package com.hyy.kcb.dao.blockchain;

import org.apache.ibatis.annotations.Mapper;

import com.hyy.kcb.commons.dao.BaseDao;
import com.hyy.kcb.domain.blockchain.TransactionWithdrawCrypto;

/**
 * @author WhiteLee
 * 功能描述:区块链资产提现流水记录(un)管理
 */
@Mapper
public interface ITransactionWithdrawCryptoDao extends BaseDao<TransactionWithdrawCrypto>{
	
	
}
