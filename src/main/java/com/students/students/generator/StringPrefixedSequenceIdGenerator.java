package com.students.students.generator;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

public class StringPrefixedSequenceIdGenerator extends SequenceStyleGenerator {

    public static final String SEQUENCE_STRING = "com.students.students.generator.StringPrefixedSequenceIdGenerator";
    public static final String INCREMENT_PARAM_VALUE = "1";
    public static final String NUMBER_FORMAT_PARAMETER_VALUE = "%08d";

    public static final String VALUE_PREFIX_ESTUDIANTE = "EST";
    public static final String VALUE_PREFIX_STUDENT = "STU";
    public static final String VALUE_PREFIX_PERSONA = "PER";
    public static final String VALUE_PREFIX_MATERIA = "MAT";
    public static final String VALUE_PREFIX_NOTA = "NT";
    public static final String VALUE_PREFIX_STUDY = "STU";
    public static final String VALUE_PREFIX_TIPOREGISTRO = "TR";

    public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
    public static final String VALUE_PREFIX_DEFAULT = "";
    private String valuePrefix;

    public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
    public static final String NUMBER_FORMAT_DEFAULT = "%d";
    private String numberFormat;

    @Override
    public Serializable generate(SharedSessionContractImplementor session,
                                 Object object) throws HibernateException {
        return valuePrefix + String.format(numberFormat, super.generate(session, object));
    }

    @Override
    public void configure(Type type, Properties params,
                          ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER,
                params, VALUE_PREFIX_DEFAULT);
        numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER,
                params, NUMBER_FORMAT_DEFAULT);
    }

}
