package com.taobao.rigel.rap.mock.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public interface MockMgr {
	/**
	 * automatically generate testing data
	 * 
	 * @param projectId
	 * @param pattern
	 * @param options
	 * @return JSON String
	 * @throws UnsupportedEncodingException
	 */
	public String generateData(int projectId, String pattern,
			Map<String, Object> options) throws UnsupportedEncodingException;

	/**
	 * modify mock data of parameters based on mockData
	 * 
	 * @param actionId
	 *            identifier of the action to be modified
	 * @param mockData
	 *            mock data string example:
	 *            response.param1.subParam=@format=x.xxxx_AND_response.
	 *            param2=@value=
	 *            1_AND_response.param3.subParam.subSubParam=@length=7
	 * @return number of rows affected
	 * 
	 */
	public int modify(int actionId, String mockData);

	/**
	 * clear all mock data of object in specified project
	 * 
	 * @param projectId
	 * @return number of rows affected
	 */
	public int reset(int projectId);

	/**
	 * generate mockjs rule
	 * 
	 * @param id projectId,  if both pattern and options are null,
     *           this id means actionId(used for OpenAPI)
	 * @param pattern
	 * @param options
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String generateRule(int id, String pattern,
			Map<String, Object> options) throws UnsupportedEncodingException;

	/**
	 * generate mockjs data
	 * 
	 * @param id
	 * @param pattern
	 * @param options
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String generateRuleData(int id, String pattern,
			Map<String, Object> options) throws UnsupportedEncodingException;

    /**
     * generate mockjs data by Action ID
     *
     * @param actionId
     * @return
     * @throws UnsupportedEncodingException
     */
    public String generateRuleData(int actionId) throws UnsupportedEncodingException;
}
