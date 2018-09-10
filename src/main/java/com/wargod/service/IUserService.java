package com.wargod.service;

import com.wargod.domain.vo.UserVo;

/**
 * @author tangj
 */
public interface IUserService {
    /**
     * 注册用户
     * @param userVo
     * @return
     */
    int regUser(UserVo userVo);
}
