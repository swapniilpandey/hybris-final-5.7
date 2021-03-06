/**
 *
 */
package com.acc.core.services.collectorder.impl;

import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.acc.core.dao.collectorder.CustomerCollectOrderDao;
import com.acc.core.services.collectorder.CustomerCollectOrderService;
import com.acc.facades.collectOrder.data.CollectOrderData;
import com.acc.model.CollectOrderModel;



/**
 * @author prasun.a.kumar
 *
 */
public class CustomerCollectOrderServiceImpl implements CustomerCollectOrderService
{
	private static final Logger LOG = Logger.getLogger(CustomerCollectOrderServiceImpl.class);
	@Autowired
	private ModelService modelService;

	private CustomerCollectOrderDao customerCollectOrderDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.core.services.collectorder.CustomerCollectOrderService#saveCustomerColectOrder(com.acc.core.model.
	 * CollectOrderModel)
	 */
	@Override
	public void saveCustomerColectOrder(final CollectOrderModel collectOrderModel)
	{
		try
		{
			modelService.save(collectOrderModel);
			LOG.info("Customer Collect Order data saved successfully.");
		}
		catch (final ModelSavingException ex)
		{
			LOG.error("Customer Collect Order data saving error [" + ex.getMessage() + "].");
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.core.services.collectorder.CustomerCollectOrderService#getCollectOrders()
	 */
	@Override
	public List<CollectOrderModel> getCollectOrders()
	{
		LOG.info("## In CustomerCollectOrderServiceImpl getCollectOrders ##");
		return customerCollectOrderDao.getCollectOrders();
	}

	/**
	 * @param customerCollectOrderDao
	 *           the customerCollectOrderDao to set
	 */
	public void setCustomerCollectOrderDao(final CustomerCollectOrderDao customerCollectOrderDao)
	{
		this.customerCollectOrderDao = customerCollectOrderDao;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.core.services.collectorder.CustomerCollectOrderService#getCollectOrderByUCOID(java.lang.String)
	 */
	@Override
	public CollectOrderModel getCollectOrderByUCOID(final String ucoid)
	{
		return customerCollectOrderDao.getCollectOrderByUCOID(ucoid);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.core.services.collectorder.CustomerCollectOrderService#getCollectOrderByOrderCode(java.lang.String)
	 */
	@Override
	public CollectOrderModel getCollectOrderByOrderCode(final String orderCode)
	{
		return customerCollectOrderDao.getCollectOrderByOrderCode(orderCode);
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.core.services.collectorder.CustomerCollectOrderService#getCustomerListOrders(java.lang.String)
	 */
	@Override
	public List<CollectOrderModel> getCustomerListOrders(final String customerID)
	{
		return customerCollectOrderDao.getCustomerListOrders(customerID);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.acc.core.services.collectorder.CustomerCollectOrderService#updateCollectOrder(com.acc.facades.collectOrder
	 * .data.CollectOrderData)
	 */
	@Override
	public void updateCollectOrder(final CollectOrderData collectOrderData)
	{
		final CollectOrderModel collectOrderModel = modelService.get(PK.fromLong((Long.valueOf(collectOrderData.getPk())
				.longValue())));
		collectOrderModel.setStatus(collectOrderData.getStatus().toString());
		saveCustomerColectOrder(collectOrderModel);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.core.services.collectorder.CustomerCollectOrderService#getOrderDetailsForCode(java.lang.String)
	 */
	@Override
	public OrderModel getOrderDetailsForCode(final String orderCode)
	{
		return customerCollectOrderDao.getOrderDetailsForCode(orderCode);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.core.services.collectorder.CustomerCollectOrderService#getCollectOrderByDateAndTime(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<CollectOrderModel> getCollectOrderByDateAndTime(final String fromDate, final String toDate, final String fromTime,
			final String toTime)
	{
		return customerCollectOrderDao.getCollectOrderByDateAndTime(fromDate, toDate, fromTime, toTime);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.acc.core.services.collectorder.CustomerCollectOrderService#getCollectOrdersByStatus(java.lang.String)
	 */
	@Override
	public List<CollectOrderModel> getCollectOrdersByStatus(final String status)
	{
		return customerCollectOrderDao.getCollectOrdersByStatus(status);
	}

}
