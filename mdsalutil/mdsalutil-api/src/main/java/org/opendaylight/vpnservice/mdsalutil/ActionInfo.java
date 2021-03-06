/*
 * Copyright (c) 2013 Ericsson AB.  All rights reserved.
 *
 */
package org.opendaylight.vpnservice.mdsalutil;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;

import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.Action;

public class ActionInfo implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final ActionType m_actionType;
    private String[] m_asActionValues = null;
    private BigInteger [] m_aBigIntValues;
    private int m_actionKey = 0;

    public ActionInfo(ActionInfo action) {
        super();
        m_actionType = action.m_actionType;
        m_actionKey = action.m_actionKey;
        m_asActionValues = Arrays.copyOf(action.m_asActionValues, action.m_asActionValues.length);
    }

    public ActionInfo(ActionType actionType, String[] asActionValues) {
        m_actionType = actionType;
        m_actionKey = 0;
        m_asActionValues = asActionValues;
    } 
    
    public ActionInfo(ActionType actionType, BigInteger[] aBigIntValues) {
        m_actionType = actionType;
        m_actionKey = 0;
        m_aBigIntValues = aBigIntValues;
    }

    public void setActionKey(int key) {
        m_actionKey = key;
    }

    public int getActionKey() {
        return m_actionKey;
    }

    public Action buildAction() {
        return m_actionType.buildAction(this);
    }

    public ActionType getActionType() {
        return m_actionType;
    }

    public String[] getActionValues() {
        return m_asActionValues;
    }
    
    public BigInteger[] getBigActionValues() {
        return m_aBigIntValues;
    }
}