/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Mar 18, 2016 1:25:12 AM                     ---
 * ----------------------------------------------------------------
 */
package com.acc.jalo;

import com.acc.constants.ServicecoreConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem TrackLatLong}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedTrackLatLong extends GenericItem
{
	/** Qualifier of the <code>TrackLatLong.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>TrackLatLong.latitude</code> attribute **/
	public static final String LATITUDE = "latitude";
	/** Qualifier of the <code>TrackLatLong.longitude</code> attribute **/
	public static final String LONGITUDE = "longitude";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(LATITUDE, AttributeMode.INITIAL);
		tmp.put(LONGITUDE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrackLatLong.code</code> attribute.
	 * @return the code
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrackLatLong.code</code> attribute.
	 * @return the code
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrackLatLong.code</code> attribute. 
	 * @param value the code
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrackLatLong.code</code> attribute. 
	 * @param value the code
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrackLatLong.latitude</code> attribute.
	 * @return the latitude
	 */
	public String getLatitude(final SessionContext ctx)
	{
		return (String)getProperty( ctx, LATITUDE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrackLatLong.latitude</code> attribute.
	 * @return the latitude
	 */
	public String getLatitude()
	{
		return getLatitude( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrackLatLong.latitude</code> attribute. 
	 * @param value the latitude
	 */
	public void setLatitude(final SessionContext ctx, final String value)
	{
		setProperty(ctx, LATITUDE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrackLatLong.latitude</code> attribute. 
	 * @param value the latitude
	 */
	public void setLatitude(final String value)
	{
		setLatitude( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrackLatLong.longitude</code> attribute.
	 * @return the longitude
	 */
	public String getLongitude(final SessionContext ctx)
	{
		return (String)getProperty( ctx, LONGITUDE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>TrackLatLong.longitude</code> attribute.
	 * @return the longitude
	 */
	public String getLongitude()
	{
		return getLongitude( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrackLatLong.longitude</code> attribute. 
	 * @param value the longitude
	 */
	public void setLongitude(final SessionContext ctx, final String value)
	{
		setProperty(ctx, LONGITUDE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>TrackLatLong.longitude</code> attribute. 
	 * @param value the longitude
	 */
	public void setLongitude(final String value)
	{
		setLongitude( getSession().getSessionContext(), value );
	}
	
}
