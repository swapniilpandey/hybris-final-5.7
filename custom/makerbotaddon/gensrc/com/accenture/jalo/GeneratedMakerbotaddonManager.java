/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Mar 18, 2016 1:25:12 AM                     ---
 * ----------------------------------------------------------------
 */
package com.accenture.jalo;

import com.accenture.constants.MakerbotaddonConstants;
import com.accenture.jalo.Makerbot;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.util.Utilities;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type <code>MakerbotaddonManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedMakerbotaddonManager extends Extension
{
	/** Relation ordering override parameter constants for Makerbot2CustomerRel from ((makerbotaddon))*/
	protected static String MAKERBOT2CUSTOMERREL_SRC_ORDERED = "relation.Makerbot2CustomerRel.source.ordered";
	protected static String MAKERBOT2CUSTOMERREL_TGT_ORDERED = "relation.Makerbot2CustomerRel.target.ordered";
	/** Relation disable markmodifed parameter constants for Makerbot2CustomerRel from ((makerbotaddon))*/
	protected static String MAKERBOT2CUSTOMERREL_MARKMODIFIED = "relation.Makerbot2CustomerRel.markmodified";
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	public Makerbot createMakerbot(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( MakerbotaddonConstants.TC.MAKERBOT );
			return (Makerbot)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Makerbot : "+e.getMessage(), 0 );
		}
	}
	
	public Makerbot createMakerbot(final Map attributeValues)
	{
		return createMakerbot( getSession().getSessionContext(), attributeValues );
	}
	
	@Override
	public String getName()
	{
		return MakerbotaddonConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.makerbot</code> attribute.
	 * @return the makerbot
	 */
	public List<Makerbot> getMakerbot(final SessionContext ctx, final Customer item)
	{
		final List<Makerbot> items = item.getLinkedItems( 
			ctx,
			false,
			MakerbotaddonConstants.Relations.MAKERBOT2CUSTOMERREL,
			null,
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_TGT_ORDERED, true)
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.makerbot</code> attribute.
	 * @return the makerbot
	 */
	public List<Makerbot> getMakerbot(final Customer item)
	{
		return getMakerbot( getSession().getSessionContext(), item );
	}
	
	public long getMakerbotCount(final SessionContext ctx, final Customer item)
	{
		return item.getLinkedItemsCount(
			ctx,
			false,
			MakerbotaddonConstants.Relations.MAKERBOT2CUSTOMERREL,
			null
		);
	}
	
	public long getMakerbotCount(final Customer item)
	{
		return getMakerbotCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.makerbot</code> attribute. 
	 * @param value the makerbot
	 */
	public void setMakerbot(final SessionContext ctx, final Customer item, final List<Makerbot> value)
	{
		item.setLinkedItems( 
			ctx,
			false,
			MakerbotaddonConstants.Relations.MAKERBOT2CUSTOMERREL,
			null,
			value,
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(MAKERBOT2CUSTOMERREL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.makerbot</code> attribute. 
	 * @param value the makerbot
	 */
	public void setMakerbot(final Customer item, final List<Makerbot> value)
	{
		setMakerbot( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to makerbot. 
	 * @param value the item to add to makerbot
	 */
	public void addToMakerbot(final SessionContext ctx, final Customer item, final Makerbot value)
	{
		item.addLinkedItems( 
			ctx,
			false,
			MakerbotaddonConstants.Relations.MAKERBOT2CUSTOMERREL,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(MAKERBOT2CUSTOMERREL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to makerbot. 
	 * @param value the item to add to makerbot
	 */
	public void addToMakerbot(final Customer item, final Makerbot value)
	{
		addToMakerbot( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from makerbot. 
	 * @param value the item to remove from makerbot
	 */
	public void removeFromMakerbot(final SessionContext ctx, final Customer item, final Makerbot value)
	{
		item.removeLinkedItems( 
			ctx,
			false,
			MakerbotaddonConstants.Relations.MAKERBOT2CUSTOMERREL,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(MAKERBOT2CUSTOMERREL_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(MAKERBOT2CUSTOMERREL_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from makerbot. 
	 * @param value the item to remove from makerbot
	 */
	public void removeFromMakerbot(final Customer item, final Makerbot value)
	{
		removeFromMakerbot( getSession().getSessionContext(), item, value );
	}
	
}
