package com.magic.basiccenter;

import com.magic.application.infrastructure.service.dto.MagicDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>todo</P>
 *
 * @author zhuzh@belink.com
 * @version 0.0.1
 * @className BasicService
 * @sine 2020/8/19 12:24
 */
@Service
public class BasicService {
    @Transactional
    public MagicDTO<Void> delete(){
        return new MagicDTO<>();
    }
}
