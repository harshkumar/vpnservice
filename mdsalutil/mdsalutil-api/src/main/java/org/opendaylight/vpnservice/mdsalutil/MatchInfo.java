/*
 * Copyright (c) 2013 Ericsson AB.  All rights reserved.
 *
 */
package org.opendaylight.vpnservice.mdsalutil;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Map;

import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.flow.MatchBuilder;

public class MatchInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private final MatchFieldType m_matchField;
    private long[] m_alMatchValues;
    private BigInteger[] m_aBigIntValues;
    private String[] m_asMatchValues;

    public MatchInfo(MatchFieldType matchField, long[] alMatchValues) {
        m_matchField = matchField;
        m_alMatchValues = alMatchValues;
    }

    public MatchInfo(MatchFieldType matchField, BigInteger[] alBigMatchValues) {
        m_matchField = matchField;
        m_aBigIntValues = alBigMatchValues;
    }

    public MatchInfo(MatchFieldType matchField, String[] alStringMatchValues) {
        m_matchField = matchField;
        m_asMatchValues = alStringMatchValues;
    }

    public void createInnerMatchBuilder(Map<Class<?>, Object> mapMatchBuilder) {
        m_matchField.createInnerMatchBuilder(this, mapMatchBuilder);
    }

    public void setMatch(MatchBuilder matchBuilder, Map<Class<?>, Object> mapMatchBuilder) {
        m_matchField.setMatch(matchBuilder, this, mapMatchBuilder);
    }

    public MatchFieldType getMatchField() {
        return m_matchField;
    }

    public long[] getMatchValues() {
        return m_alMatchValues;
    }

    public BigInteger[] getBigMatchValues() {
        return m_aBigIntValues;
    }

    public String[] getStringMatchValues() {
        return m_asMatchValues;
    }
}
