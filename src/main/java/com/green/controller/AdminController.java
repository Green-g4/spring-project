package com.green.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.service.AdminService;
import com.green.service.AuthorService;
import com.green.vo.*;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/*")
@Log4j
public class AdminController {

    @Setter(onMethod_=@Autowired)
    private AuthorService service;

    @Setter(onMethod_=@Autowired)
    private AdminService adminService;

    @RequestMapping(value="main", method = RequestMethod.GET)
    public void adminMainGET() throws Exception{

        log.info("관리자 페이지 이동");

    }

    /* 작가 상세 페이지 */
    @GetMapping({"/adminDetail", "/adminModify"})
    public void authorGetInfoGET(int authorId, Criteria cri, Model model) throws Exception {

        log.info("adminDetail......." + authorId);

        /* 작가 관리 페이지 정보 */
        model.addAttribute("cri", cri);

        /* 선택 작가 정보 */
        model.addAttribute("authorInfo", service.authorGetDetail(authorId));

    }

    /* 작가 정보 수정 */
    @PostMapping("/adminModify")
    public String authorModifyPOST(AuthorVO author, RedirectAttributes rttr) throws Exception{

        log.info("authorModifyPOST......." + author);

        int result = service.authorModify(author);

        rttr.addFlashAttribute("modify_result", result);

        return "redirect:/admin/adminManage";

    }

    /* 작가 등록 페이지 접속 */
    @RequestMapping(value = "adminEnroll", method = RequestMethod.GET)
    public void authorEnrollGET() throws Exception{
        log.info("작가 등록 페이지 접속");
    }

    /* 작가 등록 */
    @RequestMapping(value="adminEnroll.do", method = RequestMethod.POST)
    public String authorEnrollPOST(AuthorVO author, RedirectAttributes rttr) throws Exception{

        log.info("authorEnroll :" +  author);

        service.authorEnroll(author);      // 작가 등록 쿼리 수행

        rttr.addFlashAttribute("enroll_result", author.getAuthorName());

        return "redirect:/admin/adminManage";

    }

    /* 작가 관리 페이지 접속 */
    @RequestMapping(value = "adminManage", method = RequestMethod.GET)
    public void authorManageGET(Criteria cri, Model model) throws Exception{
        log.info("작가 관리 페이지 접속");
        /* 작가 목록 출력 데이터 */
        List list = service.authorGetList(cri);

        if(!list.isEmpty()) {
            model.addAttribute("list",list);	// 작가 존재 경우
        } else {
            model.addAttribute("listCheck", "empty");	// 작가 존재하지 않을 경우
        }

        model.addAttribute("list", list);

        /* 페이지 이동 인터페이스 데이터 */
        model.addAttribute("pageMaker", new PageDTO(cri, service.authorGetTotal(cri)));
    }


    /* 작가 검색 팝업창 */
    @GetMapping("/adminPop")
    public void authorPopGET(Criteria cri, Model model) throws Exception{

        log.info("adminPopGET.......");

        cri.setAmount(5);

        /* 게시물 출력 데이터 */
        List list = service.authorGetList(cri);

        if(!list.isEmpty()) {
            model.addAttribute("list",list);	// 작가 존재 경우
        } else {
            model.addAttribute("listCheck", "empty");	// 작가 존재하지 않을 경우
        }


        /* 페이지 이동 인터페이스 데이터 */
        model.addAttribute("pageMaker", new PageDTO(cri, service.authorGetTotal(cri)));

    }

    /* 작가 정보 삭제 */
    @PostMapping("/adminDelete")
    public String authorDeletePOST(int authorId, RedirectAttributes rttr) {

        log.info("authorDeletePOST..........");

        int result = 0;

        try {

            result = service.authorDelete(authorId);

        } catch (Exception e) {

            e.printStackTrace();
            result = 2;
            rttr.addFlashAttribute("delete_result", result);

            return "redirect:/admin/adminManage";

        }


        rttr.addFlashAttribute("delete_result", result);

        return "redirect:/admin/adminManage";

    }

    /* 상품 조회 페이지 */
    @GetMapping({"/goodsDetail", "/goodsModify"})
    public void goodsGetInfoGET(int id, Criteria cri, Model model) throws JsonProcessingException {

        log.info("goodsGetInfo()........." + id);

        ObjectMapper mapper = new ObjectMapper();

        /* 카테고리 리스트 데이터 */
        model.addAttribute("cateList", mapper.writeValueAsString(adminService.cateList()));

        /* 목록 페이지 조건 정보 */
        model.addAttribute("cri", cri);

        /* 조회 페이지 정보 */
        model.addAttribute("goodsInfo", adminService.goodsGetDetail(id));

    }

    /* 상품 정보 수정 */
    @PostMapping("/goodsModify")
    public String goodsModifyPOST(ProductVO vo, RedirectAttributes rttr) {

        log.info("goodsModifyPOST.........." + vo);

        int result = adminService.goodsModify(vo);

        rttr.addFlashAttribute("modify_result", result);

        return "redirect:/admin/goodsManage";

    }

    /* 상품 등록 페이지 접속 */
    @RequestMapping(value = "goodsEnroll", method = RequestMethod.GET)
    public void goodsEnrollGET(Model model) throws Exception{
        log.info("상품 등록 페이지 접속");
        ObjectMapper objm = new ObjectMapper();
        List list = adminService.cateList();
        String cateList = objm.writeValueAsString(list);
        model.addAttribute("cateList", cateList);
        log.info("변경 전.........." + list);
        log.info("변경 후.........." + cateList);
    }

    /* 상품 등록 */
    @PostMapping("/goodsEnroll")
    public String goodsEnrollPOST(ProductVO product, RedirectAttributes rttr) {

        log.info("goodsEnrollPOST......" + product);

        adminService.ProductEnroll(product);

        rttr.addFlashAttribute("enroll_result", product.getProduct_name());

        return "redirect:/admin/goodsManage";
    }

    /* 상품 관리(상품목록) 페이지 접속 */
    @RequestMapping(value = "goodsManage", method = RequestMethod.GET)
    public void goodsManageGET(Criteria cri, Model model) throws Exception{
        /* 상품 리스트 데이터 */
        List list = adminService.goodsGetList(cri);

        if(!list.isEmpty()) {
            model.addAttribute("list", list);
        } else {
            model.addAttribute("listCheck", "empty");
            return;
        }

        /* 페이지 인터페이스 데이터 */
        model.addAttribute("pageMaker", new PageDTO(cri, adminService.goodsGetTotal(cri)));

    }

    /* 상품 정보 삭제 */
    @PostMapping("/goodsDelete")
    public String goodsDeletePOST(int id, RedirectAttributes rttr) {

        log.info("goodsDeletePOST..........");

        int result = adminService.goodsDelete(id);

        rttr.addFlashAttribute("delete_result", result);

        return "redirect:/admin/goodsManage";

    }

    /* 첨부 파일 업로드 */
    @PostMapping(value="/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<AttachImageVO>> uploadAjaxActionPOST(MultipartFile[] uploadFile) {

        log.info("uploadAjaxActionPOST..........");

        /* 이미지 파일 체크 */
        for(MultipartFile multipartFile: uploadFile) {

            File checkfile = new File(multipartFile.getOriginalFilename());
            String type = null;

            try {
                type = Files.probeContentType(checkfile.toPath());
                log.info("MIME TYPE : " + type);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(!type.startsWith("image")) {

                List<AttachImageVO> list = null;
                return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);

            }

        }// for

        String uploadFolder = "C:\\upload";

        /* 날짜 폴더 경로 */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        String str = sdf.format(date);

        String datePath = str.replace("-", File.separator);

        /* 폴더 생성 */
        File uploadPath = new File(uploadFolder, datePath);

        if(uploadPath.exists() == false) {
            uploadPath.mkdirs();
        }

        /* 이미저 정보 담는 객체 */
        List<AttachImageVO> list = new ArrayList();

        // 향상된 for
        for(MultipartFile multipartFile : uploadFile) {
            log.info("-----------------------------------------------");
            log.info("파일 이름 : " + multipartFile.getOriginalFilename());
            log.info("파일 타입 : " + multipartFile.getContentType());
            log.info("파일 크기 : " + multipartFile.getSize());
            /* 이미지 정보 객체 */
            AttachImageVO vo = new AttachImageVO();

            /* 파일 이름 */
            String uploadFileName = multipartFile.getOriginalFilename();
            vo.setFileName(uploadFileName);
            vo.setUploadPath(datePath);

            /* uuid 적용 파일 이름 */
            String uuid = UUID.randomUUID().toString();
            vo.setUuid(uuid);

            uploadFileName = uuid + "_" + uploadFileName;

            /* 파일 위치, 파일 이름을 합친 File 객체 */
            File saveFile = new File(uploadPath, uploadFileName);

            /* 파일 저장 */
            try {

                multipartFile.transferTo(saveFile);

                /* 썸네일 생성(ImageIO) */

                File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);

                BufferedImage bo_image = ImageIO.read(saveFile);
                BufferedImage bt_image = new BufferedImage(900, 900, BufferedImage.TYPE_3BYTE_BGR);

                Graphics2D graphic = bt_image.createGraphics();

                graphic.drawImage(bo_image, 0, 0,900,900, null);

                ImageIO.write(bt_image, "jpg", thumbnailFile);


                /* 방법 2 */
                /*File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);

                BufferedImage bo_image = ImageIO.read(saveFile);

                //비율
                double ratio = 3;
                //넓이 높이
                int width = (int) (bo_image.getWidth() / ratio);
                int height = (int) (bo_image.getHeight() / ratio);


                Thumbnails.of(saveFile)
                        .size(width, height)
                        .toFile(thumbnailFile);*/


            } catch (Exception e) {

                e.printStackTrace();

            }

            list.add(vo);

        } //for

        ResponseEntity<List<AttachImageVO>> result = new ResponseEntity<List<AttachImageVO>>(list, HttpStatus.OK);

        return result;
    }

    /* 이미지 파일 삭제 */
    @PostMapping("/deleteFile")
    public ResponseEntity<String> deleteFile(String fileName){

        log.info("deleteFile........" + fileName);
        File file = null;
        try {
            /* 썸네일 파일 삭제 */
            file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));

            file.delete();

            /* 원본 파일 삭제 */
            String originFileName = file.getAbsolutePath().replace("s_", "");

            log.info("originFileName : " + originFileName);

            file = new File(originFileName);

            file.delete();


        } catch(Exception e) {

            e.printStackTrace();

            return new ResponseEntity<String>("fail", HttpStatus.NOT_IMPLEMENTED);

        } // catch

        return new ResponseEntity<String>("success", HttpStatus.OK);


    }
}
