package com.zx.starter.controller.user;

import com.zx.domain.po.users.Users;
import com.zx.service.core.users.UsersService;
import com.zx.starter.controller.aspect.AspectTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author zhouxiong
 * @Title: UsersController
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/8/1513:50
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UsersController {

    @Resource
    private UsersService usersService;

    @GetMapping("/getAll")
    public Future<List<Users>> selectAll(){
        CompletableFuture<List<Users>> futurePrice = new CompletableFuture<>();
        new Thread(()->{
            futurePrice.complete(usersService.selectAll());
        }).start();
        return futurePrice;

    }

    @AspectTest
    @GetMapping("/getUser")
    public Users getUser(Integer id){
        Users users = usersService.selectById(id);
        return users;
    }

    @PostMapping("/addUser")
    public int addUser(@RequestBody Users users){
        return  usersService.addUser(users);
    }

    @GetMapping("/getList")
    public  List<Map<String,Object>> getList(){
        return usersService.selectMap();
    }





   /*  troubleShootingList.stream().forEach(t -> {
        ExperimentTroubleShootingInfoVo shootingInfoVo = new ExperimentTroubleShootingInfoVo();
        BeanUtils.copyProperties(t, shootingInfoVo);

        List<FileManage> reasonFileManages = fileManageService.selectList(OssFileEnum.TroubleShootingReason, t.getId());

        List<FileManage> reasonImageVideoList = new LinkedList<>();
        List<FileManage> reasonAudioList = new LinkedList<>();
        reasonFileManages.forEach(r -> {
            if (r.getFileType().equals(FileTypeEnum.Video.getValue()) || r.getFileType().equals(FileTypeEnum.Image.getValue())) {
                shootingInfoVo.getReasonImageVideoList().add(r);
                reasonImageVideoList.add(r);
            }else if (r.getFileType().equals(FileTypeEnum.Audio.getValue())){
                reasonAudioList.add(r);
            }
        });
        shootingInfoVo.setReasonImageVideoList(reasonImageVideoList);
        shootingInfoVo.setReasonAudioList(reasonAudioList);

        List<FileManage> dealFileManages = fileManageService.selectList(OssFileEnum.TroubleShootingDeal, t.getId());
        List<FileManage> dealImageVideoList = new LinkedList<>();
        List<FileManage> dealAudioList = new LinkedList<>();
        dealFileManages.forEach(d -> {
            if (d.getFileType().equals(FileTypeEnum.Video.getValue()) || d.getFileType().equals(FileTypeEnum.Image.getValue())) {
                dealImageVideoList.add(d);
            }else if (d.getFileType().equals(FileTypeEnum.Audio.getValue())){
                dealAudioList.add(d);
            }
        });
        shootingInfoVo.setDealImageVideoList(reasonImageVideoList);
        shootingInfoVo.setDealAudioList(reasonAudioList);
        troubleShootingInfoVos.add(shootingInfoVo);
    });
    */










}
