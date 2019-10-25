package com.bilikai.boot.accounts.service.impl;

import com.bilikai.boot.accounts.entity.Accounts;
import com.bilikai.boot.accounts.mapper.AccountsMapper;
import com.bilikai.boot.accounts.service.IAccountsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author long
 * @since 2019-10-25
 */
@Service
public class AccountsServiceImpl extends ServiceImpl<AccountsMapper, Accounts> implements IAccountsService {

}
