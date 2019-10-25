package com.bilikai.boot.accounts.entity;

import com.bilikai.bootdb.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author long
 * @since 2019-10-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Accounts对象", description="")
public class Accounts extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String account;

    private Integer phone;

    private String passWord;

    private String nickName;


}
