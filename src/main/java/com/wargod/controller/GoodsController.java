package com.wargod.controller;

import com.wargod.constant.WebConstant;
import com.wargod.domain.bo.RestResponseBo;
import com.wargod.domain.dto.Exposer;
import com.wargod.domain.vo.GoodsVo;
import com.wargod.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class GoodsController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    GoodsService goodsService;

    /**
     * 列表页
     * @param request
     * @return
     */
    @GetMapping("")
    public String index(HttpServletRequest request){
        List<GoodsVo> goodVoList = goodsService.getGoodsList();
        request.setAttribute(WebConstant.GOODS_LIST,goodVoList);
        return "goodslist";
    }

    /**
     * 详情页
     *
     * @param gid
     * @param request
     * @return
     */
    @GetMapping(value = "/{gid}/detail")
    public String goodDetail(@PathVariable("gid")Integer gid,HttpServletRequest request){
        if (gid == null){
            return "redirect:/";
        }
        GoodsVo goodVo = goodsService.getGoodsById(gid);
        if (goodVo == null){
            return "redirect:/";
        }
        request.setAttribute(WebConstant.GOODS_DETAIL,goodVo);
        return "detail";
    }

    /**
     * 获取服务器当前时间
     * @return
     */
    @GetMapping(value = "/time/now")
    @ResponseBody
    public RestResponseBo getNowTime(){
        Date date = new Date();
        return RestResponseBo.ok(date.getTime());
    }

    @PostMapping(value = "/{seckillId}/exposer")
    @ResponseBody
    public RestResponseBo<Exposer> exposerUrl(@PathVariable("seckillId") Integer seckillId){
        try {
            Exposer exposer = goodsService.exportSeckillUrl(seckillId);
            return RestResponseBo.ok(exposer);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return RestResponseBo.fail("获取秒杀地址失败");
        }
    }

    @PostMapping(value = "/{seckillId}/{md5}/execution")
    @ResponseBody
    public RestResponseBo executeSecKill(@PathVariable("seckillId") Long seckillId, @PathVariable("md5") String md5, @CookieValue(value = "userPhone", required = false) Long userPhone){
        if (userPhone==null){
            return RestResponseBo.fail("请先注册");
        }

    }
}
