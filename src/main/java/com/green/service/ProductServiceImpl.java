package com.green.service;

import com.green.mapper.AdminMapper;
import com.green.mapper.AttachMapper;
import com.green.mapper.ProductMapper;
import com.green.vo.*;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j
public class ProductServiceImpl implements ProductService{

    @Setter(onMethod_=@Autowired)
    private ProductMapper mapper;

    @Setter(onMethod_= @Autowired)
    private AttachMapper attachMapper;

    @Setter(onMethod_= @Autowired)
    private AdminMapper adminMapper;

    @Override
    public List<ProductVO> getListAsc(Criteria cri) {
        log.info("서비스에서 product getList 오름차순---------------------------------");
        List<ProductVO> list = mapper.getListAsc(cri);

        list.forEach(product -> {

            int id = product.getId();

            List<AttachImageVO> imageList = attachMapper.getAttachList(id);

            product.setImageList(imageList);

        });

        return list;
    }

    @Override
    public List<ProductVO> getList(Criteria cri) {
        log.info("서비스에서 product getList 내림차순 + 10개씩---------------------------------");
        List<ProductVO> list = mapper.getList(cri);

        list.forEach(product -> {

            int id = product.getId();

            List<AttachImageVO> imageList = attachMapper.getAttachList(id);

            product.setImageList(imageList);

        });

        return list;
    }

    @Override
    public List<ProductVO> getListCategory(String cateName) {
        log.info("서비스에서 product getList 내림차순 + 10개씩---------------------------------");
        List<ProductVO> list = mapper.getListCategory(cateName);

        list.forEach(product -> {

            int id = product.getId();

            List<AttachImageVO> imageList = attachMapper.getAttachList(id);

            product.setImageList(imageList);

        });

        return list;
    }

    @Override
    public List<ProductVO> getListCategory1(Criteria cri) {
        log.info("서비스에서 product getListCategory(digital/homeapp)---------------------------------");
        List<ProductVO> list = mapper.getListCategory1(cri);

        list.forEach(product -> {

            int id = product.getId();

            List<AttachImageVO> imageList = attachMapper.getAttachList(id);

            product.setImageList(imageList);

        });

        return list;
    }

    @Override
    public List<ProductVO> getListCategory2(Criteria cri) {
        log.info("서비스에서 product getListCategory(life/health)---------------------------------");
        List<ProductVO> list = mapper.getListCategory2(cri);

        list.forEach(product -> {

            int id = product.getId();

            List<AttachImageVO> imageList = attachMapper.getAttachList(id);

            product.setImageList(imageList);

        });

        return list;
    }

    @Override
    public List<ProductVO> getListCategory3(Criteria cri) {
        log.info("서비스에서 product getListCategory(sports/leisure)---------------------------------");
        List<ProductVO> list = mapper.getListCategory3(cri);

        list.forEach(product -> {

            int id = product.getId();

            List<AttachImageVO> imageList = attachMapper.getAttachList(id);

            product.setImageList(imageList);

        });

        return list;
    }

    @Override
    public List<ProductVO> getListPriceDesc1(Criteria cri) {
        log.info("서비스에서 product getListCategory(digital/homeapp) 내림차순---------------------------------");
        List<ProductVO> list = mapper.getListPriceDesc1(cri);

        list.forEach(product -> {

            int id = product.getId();

            List<AttachImageVO> imageList = attachMapper.getAttachList(id);

            product.setImageList(imageList);

        });

        return list;
    }

    @Override
    public List<ProductVO> getListPriceAsc1(Criteria cri) {
        log.info("서비스에서 product getListCategory(digital/homeapp) 오름차순---------------------------------");
        List<ProductVO> list = mapper.getListPriceAsc1(cri);

        list.forEach(product -> {

            int id = product.getId();

            List<AttachImageVO> imageList = attachMapper.getAttachList(id);

            product.setImageList(imageList);

        });

        return list;
    }

    @Override
    public List<ProductVO> getListPriceDesc2(Criteria cri) {
        log.info("서비스에서 product getListCategory(life/health) 내림차순---------------------------------");
        List<ProductVO> list = mapper.getListPriceDesc2(cri);

        list.forEach(product -> {

            int id = product.getId();

            List<AttachImageVO> imageList = attachMapper.getAttachList(id);

            product.setImageList(imageList);

        });

        return list;
    }

    @Override
    public List<ProductVO> getListPriceAsc2(Criteria cri) {
        log.info("서비스에서 product getListCategory(life/health) 오름차순---------------------------------");
        List<ProductVO> list = mapper.getListPriceAsc2(cri);

        list.forEach(product -> {

            int id = product.getId();

            List<AttachImageVO> imageList = attachMapper.getAttachList(id);

            product.setImageList(imageList);

        });

        return list;
    }

    @Override
    public List<ProductVO> getListPriceDesc3(Criteria cri) {
        log.info("서비스에서 product getListCategory(sports/leisure) 내림차순---------------------------------");
        List<ProductVO> list = mapper.getListPriceDesc3(cri);

        list.forEach(product -> {

            int id = product.getId();

            List<AttachImageVO> imageList = attachMapper.getAttachList(id);

            product.setImageList(imageList);

        });

        return list;
    }

    @Override
    public List<ProductVO> getListPriceAsc3(Criteria cri) {
        log.info("서비스에서 product getListCategory(sports/leisure) 오름차순---------------------------------");
        List<ProductVO> list = mapper.getListPriceAsc3(cri);

        list.forEach(product -> {

            int id = product.getId();

            List<AttachImageVO> imageList = attachMapper.getAttachList(id);

            product.setImageList(imageList);

        });

        return list;
    }

    @Override
    public int productGetTotal(Criteria cri) {
        log.info("서비스에서 product productGetTotal---------------------------------");
        return mapper.productGetTotal(cri);
    }

    @Override
    public int productGetTotalCate1(Criteria cri) {
        log.info("서비스에서 product productGetTotal(digital/homeapp)---------------------------------");
        return mapper.productGetTotalCate1(cri);
    }

    @Override
    public int productGetTotalCate2(Criteria cri) {
        log.info("서비스에서 product productGetTotal(life/health)---------------------------------");
        return mapper.productGetTotalCate2(cri);
    }

    @Override
    public int productGetTotalCate3(Criteria cri) {
        log.info("서비스에서 product productGetTotal(sports/leisure)---------------------------------");
        return mapper.productGetTotalCate3(cri);
    }

    @Override
    public List<ProductVO> getGoodsList(Criteria cri) {

        log.info("getGoodsList().......");

        String type = cri.getType();
        String[] typeArr = type.split("");
        String[] authorArr = mapper.getAuthorIdList(cri.getKeyword());


        if(type.equals("A") || type.equals("AC") || type.equals("AT") || type.equals("ACT")) {
            if(authorArr.length == 0) {
                return new ArrayList();
            }
        }

        for(String t : typeArr) {
            if(t.equals("A")) {
                cri.setAuthorArr(authorArr);
            }
        }

        List<ProductVO> list = mapper.getGoodsList(cri);

        list.forEach(product -> {

            int id = product.getId();

            List<AttachImageVO> imageList = attachMapper.getAttachList(id);

            product.setImageList(imageList);

        });

        return list;
    }

    @Override
    public int goodsGetTotal(Criteria cri) {

        log.info("goodsGetTotal().......");

        return mapper.goodsGetTotal(cri);

    }

    @Override
    public List<CategoryVO> getCateCode1() {

        log.info("getCateCode1().........");

        return mapper.getCateCode1();
    }

    @Override
    public List<CategoryVO> getCateCode2() {

        log.info("getCateCode2().........");

        return mapper.getCateCode2();
    }

    @Override
    public List<CateFilterDTO> getCateInfoList(Criteria cri) {

        List<CateFilterDTO> filterInfoList = new ArrayList<CateFilterDTO>();

        String[] typeArr = cri.getType().split("");
        String [] authorArr;

        for(String type : typeArr) {
            if(type.equals("A")){
                authorArr = mapper.getAuthorIdList(cri.getKeyword());
                if(authorArr.length == 0) {
                    return filterInfoList;
                }
                cri.setAuthorArr(authorArr);
            }
        }

        String[] cateList = mapper.getCateList(cri);

        String tempCateCode = cri.getCateCode();

        for(String cateCode : cateList) {
            cri.setCateCode(cateCode);
            CateFilterDTO filterInfo = mapper.getCateInfo(cri);
            filterInfoList.add(filterInfo);
        }

        cri.setCateCode(tempCateCode);

        return filterInfoList;
    }

    @Override
    public ProductVO getGoodsInfo(int id) {

        ProductVO goodsInfo = mapper.getGoodsInfo(id);
        goodsInfo.setImageList(adminMapper.getAttachInfo(id));
        return goodsInfo;
    }

    @Override
    public void insert(ProductVO vo) {
        log.info("서비스에서 product insert----------------------------------");
        mapper.insert(vo);
    }

    @Override
    public ProductVO read(int id) {
        log.info("서비스에서 product read------------------");
        return mapper.read(id);
    }

    @Override
    public void update(ProductVO vo) {
        log.info("서비스에서 product update------------------");
        mapper.update(vo);
    }

    @Override
    public void delete(int id) {
        log.info("서비스에서 product delete------------------");
        mapper.delete(id);
    }
}
