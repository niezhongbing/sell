//package com.nzb.cn.sell.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//
//public class RestTemplateController {
//
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//
//    @Autowired
//   // private RestTemplate restTemplate;
//
//    /**
//     * resttemplate 三种调用方法
//     *
//     * @return
//     */
//    @RequestMapping
//    public String Test() {
//        //resttemplate 三种调用方法
//
//        //第一种方式（直接使用restTemplate,url写死）
////        RestTemplate restTemplate = new RestTemplate();
////        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);
//        //第二种方式（利用loadBalancerClient通过应用获取url,然后再使用restTemplate）
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("服务名");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort(), "/msg");
//        String response = restTemplate.getForObject(url, String.class);
//        //第三种方式(利用@LoadBalanced,可在restTemplate里使用应用的名字)
//       //String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);
//        return response;
//    }
//
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate (){
//        return new RestTemplate();
//    }
//}
