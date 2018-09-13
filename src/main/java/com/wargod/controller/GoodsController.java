package com.wargod.controller;

import com.wargod.constant.WebConstant;
import com.wargod.domain.bo.RestResponseBo;
import com.wargod.domain.dto.Exposer;
import com.wargod.domain.vo.GoodsVo;
import com.wargod.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class GoodsController {

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

    @PostMapping(value = "/{seckillId}/{md5}/execution")
    public RestResponseBo<Exposer> exposerUrl(@PathVariable("seckillId") Long seckillId){


        return RestResponseBo.ok();
    }
}
