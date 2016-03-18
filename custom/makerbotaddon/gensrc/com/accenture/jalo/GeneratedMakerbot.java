/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Mar 18, 2016 1:25:12 AM                     ---
 * ----------------------------------------------------------------
 */
package com.accenture.jalo;

import com.accenture.constants.MakerbotaddonConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.util.Utilities;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem Makerbot}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedMakerbot extends GenericItem
{
	/** Qualifier of the <code>Makerbot.username</code> attribute **/
	public static final String USERNAME = "username";
	/** Qualifier of the <code>Makerbot.password</code> attribute **/
	public static final String PASSWORD = "password";
	/** Qualifier of the <code>Makerbot.thingurl</code> attribute **/
	public static final String THINGURL = "thingurl";
	/** Qualifier of the <code>Makerbot.description</code> attribute **/
	public static final String DESCRIPTION = "description";
	/** Qualifier of the <code>Makerbot.customermakerbotstatus</code> attribute **/
	public static final String CUSTOMERMAKERBOTSTATUS = "customermakerbotstatus";
	/** Qualifier of the <code>Makerbot.customer</code> attribute **/
	public static final String CUSTOMER = "customer";
	/** Relation ordering override parameter constants for Makerbot2CustomerRel from ((makerbotaddon))*/
	protected static String MAKERBOT2CUSTOMERREL_SRC_ORDERED = "relation.Makerbot2CustomerRel.source.ordered";
	protected static String MAKERBOT2CUSTOMERREL_TGT_ORDERED = "relation.Makerbot2CustomerRel.target.ordered";
	/** Relation disable markmodifed parameter constants for Makerbot2CustomerRel from ((makerbotaddon))*/
	protected static String MAKERBOT2CUSTOMERREL_MARKMODIFIED = "relation.Makerbot2CustomerRel.markmodified";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(USERNAME, AttributeMode.INITIAL);
		tmp.put(PASSWORD, AttributeMode.INITIAL);
		tmp.put(THINGURL, AttributeMode.INITIAL);
		tmp.put(DESCRIPTION, AttributeMode.INITIAL);
		tmp.put(CUSTOMERMAKERBOTSTATUS, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Makerbot.customer</code> attribute.
	 * @return the customer
	 */
	public List<Customer> getCustomer(final SessionContext ctx)
	{
		final List<Customer> items = getLinkedItems( 
			ctx,
			true,
			MakerbotaddonConstants.Relations.MAKERBOT2CUSTOMERREL,
			null,
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_TGT_ORDERED, true)
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Makerbot.customer</code> attribute.
	 * @return the customer
	 */
	public List<Customer> getCustomer()
	{
		return getCustomer( getSession().getSessionContext() );
	}
	
	public long getCustomerCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			true,
			MakerbotaddonConstants.Relations.MAKERBOT2CUSTOMERREL,
			null
		);
	}
	
	public long getCustomerCount()
	{
		return getCustomerCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Makerbot.customer</code> attribute. 
	 * @param value the customer
	 */
	public void setCustomer(final SessionContext ctx, final List<Customer> value)
	{
		setLinkedItems( 
			ctx,
			true,
			MakerbotaddonConstants.Relations.MAKERBOT2CUSTOMERREL,
			null,
			value,
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(MAKERBOT2CUSTOMERREL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Makerbot.customer</code> attribute. 
	 * @param value the customer
	 */
	public void setCustomer(final List<Customer> value)
	{
		setCustomer( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to customer. 
	 * @param value the item to add to customer
	 */
	public void addToCustomer(final SessionContext ctx, final Customer value)
	{
		addLinkedItems( 
			ctx,
			true,
			MakerbotaddonConstants.Relations.MAKERBOT2CUSTOMERREL,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(MAKERBOT2CUSTOMERREL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to customer. 
	 * @param value the item to add to customer
	 */
	public void addToCustomer(final Customer value)
	{
		addToCustomer( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from customer. 
	 * @param value the item to remove from customer
	 */
	public void removeFromCustomer(final SessionContext ctx, final Customer value)
	{
		removeLinkedItems( 
			ctx,
			true,
			MakerbotaddonConstants.Relations.MAKERBOT2CUSTOMERREL,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(MAKERBOT2CUSTOMERREL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from customer. 
	 * @param value the item to remove from customer
	 */
	public void removeFromCustomer(final Customer value)
	{
		removeFromCustomer( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Makerbot.customermakerbotstatus</code> attribute.
	 * @return the customermakerbotstatus
	 */
	public Boolean isCustomermakerbotstatus(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, CUSTOMERMAKERBOTSTATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Makerbot.customermakerbotstatus</code> attribute.
	 * @return the customermakerbotstatus
	 */
	public Boolean isCustomermakerbotstatus()
	{
		return isCustomermakerbotstatus( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Makerbot.customermakerbotstatus</code> attribute. 
	 * @return the customermakerbotstatus
	 */
	public boolean isCustomermakerbotstatusAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isCustomermakerbotstatus( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Makerbot.customermakerbotstatus</code> attribute. 
	 * @return the customermakerbotstatus
	 */
	public boolean isCustomermakerbotstatusAsPrimitive()
	{
		return isCustomermakerbotstatusAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Makerbot.customermakerbotstatus</code> attribute. 
	 * @param value the customermakerbotstatus
	 */
	public void setCustomermakerbotstatus(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, CUSTOMERMAKERBOTSTATUS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Makerbot.customermakerbotstatus</code> attribute. 
	 * @param value the customermakerbotstatus
	 */
	public void setCustomermakerbotstatus(final Boolean value)
	{
		setCustomermakerbotstatus( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Makerbot.customermakerbotstatus</code> attribute. 
	 * @param value the customermakerbotstatus
	 */
	public void setCustomermakerbotstatus(final SessionContext ctx, final boolean value)
	{
		setCustomermakerbotstatus( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Makerbot.customermakerbotstatus</code> attribute. 
	 * @param value the customermakerbotstatus
	 */
	public void setCustomermakerbotstatus(final boolean value)
	{
		setCustomermakerbotstatus( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Makerbot.description</code> attribute.
	 * @return the description
	 */
	public Collection<String> getDescription(final SessionContext ctx)
	{
		Collection<String> coll = (Collection<String>)getProperty( ctx, DESCRIPTION);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Makerbot.description</code> attribute.
	 * @return the description
	 */
	public Collection<String> getDescription()
	{
		return getDescription( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Makerbot.description</code> attribute. 
	 * @param value the description
	 */
	public void setDescription(final SessionContext ctx, final Collection<String> value)
	{
		setProperty(ctx, DESCRIPTION,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Makerbot.description</code> attribute. 
	 * @param value the description
	 */
	public void setDescription(final Collection<String> value)
	{
		setDescription( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Makerbot.password</code> attribute.
	 * @return the password
	 */
	public String getPassword(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PASSWORD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Makerbot.password</code> attribute.
	 * @return the password
	 */
	public String getPassword()
	{
		return getPassword( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Makerbot.password</code> attribute. 
	 * @param value the password
	 */
	public void setPassword(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PASSWORD,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Makerbot.password</code> attribute. 
	 * @param value the password
	 */
	public void setPassword(final String value)
	{
		setPassword( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Makerbot.thingurl</code> attribute.
	 * @return the thingurl
	 */
	public Collection<String> getThingurl(final SessionContext ctx)
	{
		Collection<String> coll = (Collection<String>)getProperty( ctx, THINGURL);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Makerbot.thingurl</code> attribute.
	 * @return the thingurl
	 */
	public Collection<String> getThingurl()
	{
		return getThingurl( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Makerbot.thingurl</code> attribute. 
	 * @param value the thingurl
	 */
	public void setThingurl(final SessionContext ctx, final Collection<String> value)
	{
		setProperty(ctx, THINGURL,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Makerbot.thingurl</code> attribute. 
	 * @param value the thingurl
	 */
	public void setThingurl(final Collection<String> value)
	{
		setThingurl( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Makerbot.username</code> attribute.
	 * @return the username
	 */
	public String getUsername(final SessionContext ctx)
	{
		return (String)getProperty( ctx, USERNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Makerbot.username</code> attribute.
	 * @return the username
	 */
	public String getUsername()
	{
		return getUsername( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Makerbot.username</code> attribute. 
	 * @param value the username
	 */
	public void setUsername(final SessionContext ctx, final String value)
	{
		setProperty(ctx, USERNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Makerbot.username</code> attribute. 
	 * @param value the username
	 */
	public void setUsername(final String value)
	{
		setUsername( getSession().getSessionContext(), value );
	}
	
}
