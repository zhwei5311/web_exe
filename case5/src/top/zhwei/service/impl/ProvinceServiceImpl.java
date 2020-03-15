package top.zhwei.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import top.zhwei.dao.ProvinceDao;
import top.zhwei.dao.impl.ProvinceDaoImpl;
import top.zhwei.domain.Province;
import top.zhwei.jedis.util.JedisPoolUtils;
import top.zhwei.service.ProvinceService;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    //声明dao
    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }


    /**
        使用redis缓存
     */
    @Override
    public String findAllJson() {
        //从redis查询数据
        //获取redis客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province = jedis.get("province");
        //判断province是否为空
        if(null == province || 0 == province.length()) {
            System.err.println("redis中没有数据，需要查询数据库");
            List<Province> provinceList = dao.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                province = objectMapper.writeValueAsString(provinceList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",province);
            jedis.close();
        } else {
            System.err.println("数据已经被存入redis缓存中！");
        }
        return province;
    }


}
