package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.ChuzufangDao;
import com.entity.ChuzufangEntity;
import com.service.ChuzufangService;
import com.entity.view.ChuzufangView;

/**
 * 出租房 服务实现类
 */
@Service("chuzufangService")
@Transactional
public class ChuzufangServiceImpl extends ServiceImpl<ChuzufangDao, ChuzufangEntity> implements ChuzufangService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ChuzufangView> page =new Query<ChuzufangView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
