/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.clinicalsummary.rule.tuberculosis.reminders;

import org.openmrs.logic.LogicContext;
import org.openmrs.logic.result.Result;
import org.openmrs.module.clinicalsummary.rule.EvaluableRule;
import org.openmrs.module.clinicalsummary.rule.reminder.ReminderParameters;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.element.Element10ARule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.element.Element10BRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.element.Element10CRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.element.Element10DRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.element.Element10ERule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.element.Element12ARule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.element.Element12BRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.element.Element12CRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion1BRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion1CRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion2ARule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion2BRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion2CRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion2DRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion2ERule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion2FRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion2GRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion3ARule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion3BRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion3DRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion4ARule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion4BRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion4CRule;
import org.openmrs.module.clinicalsummary.rule.tuberculosis.exclusion.Exclusion4DRule;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Write brief description about the class here.
 */
public class Reminder12Rule extends EvaluableRule {

    public static final String TOKEN = "Tuberculosis: Reminder 12";

    /**
     * @param context
     * @param patientId
     * @param parameters
     * @return
     * @see org.openmrs.logic.Rule#eval(org.openmrs.logic.LogicContext, Integer, java.util.Map)
     */
    @Override
    protected Result evaluate(final LogicContext context, final Integer patientId, final Map<String, Object> parameters) {
        Result result = new Result();

//        Exclusion1ARule exclusion1ARule = new Exclusion1ARule();
//        Result exclusion1AResult = exclusion1ARule.eval(context, patientId, new HashMap<String, Object>());
//        if (exclusion1AResult.toBoolean()) {
//            result.add(new Result("Reminder 12 excluded by Ex1A"));
//            return result;
//        }
//
        Exclusion1BRule exclusion1BRule = new Exclusion1BRule();
        Result exclusion1BResult = exclusion1BRule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion1BResult.toBoolean()) {
            return result;
        }

        Exclusion1CRule exclusion1CRule = new Exclusion1CRule();
        Result exclusion1CResult = exclusion1CRule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion1CResult.toBoolean()) {
            return result;
        }
//
//        Exclusion1DRule exclusion1DRule = new Exclusion1DRule();
//        Result exclusion1DResult = exclusion1DRule.eval(context, patientId, new HashMap<String, Object>());
//        if (exclusion1DResult.toBoolean()) {
//            result.add(new Result("Reminder 12 excluded by Ex1D"));
//            return result;
//        }

        Exclusion2ARule exclusion2ARule = new Exclusion2ARule();
        Result exclusion2AResult = exclusion2ARule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion2AResult.toBoolean()) {
            return result;
        }

        Exclusion2BRule exclusion2BRule = new Exclusion2BRule();
        Result exclusion2BResult = exclusion2BRule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion2BResult.toBoolean()) {
            return result;
        }

        Exclusion2CRule exclusion2CRule = new Exclusion2CRule();
        Result exclusion2CResult = exclusion2CRule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion2CResult.toBoolean()) {
            return result;
        }

        Exclusion2DRule exclusion2DRule = new Exclusion2DRule();
        Result exclusion2DResult = exclusion2DRule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion2DResult.toBoolean()) {
            return result;
        }

        Exclusion2FRule exclusion2FRule = new Exclusion2FRule();
        Result exclusion2FResult = exclusion2FRule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion2FResult.toBoolean()) {
            return result;
        }

        Exclusion2ERule exclusion2ERule = new Exclusion2ERule();
        Result exclusion2EResult = exclusion2ERule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion2EResult.toBoolean()) {
            return result;
        }

        Exclusion2GRule exclusion2GRule = new Exclusion2GRule();
        Result exclusion2GResult = exclusion2GRule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion2GResult.toBoolean()) {
            return result;
        }

        Exclusion3ARule exclusion3ARule = new Exclusion3ARule();
        Result exclusion3AResult = exclusion3ARule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion3AResult.toBoolean()) {
            return result;
        }

        Exclusion3BRule exclusion3BRule = new Exclusion3BRule();
        Result exclusion3BResult = exclusion3BRule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion3BResult.toBoolean()) {
            return result;
        }

        Exclusion3DRule exclusion3DRule = new Exclusion3DRule();
        Result exclusion3DResult = exclusion3DRule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion3DResult.toBoolean()) {
            return result;
        }

        Exclusion4ARule exclusion4ARule = new Exclusion4ARule();
        Result exclusion4AResult = exclusion4ARule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion4AResult.toBoolean()) {
            return result;
        }

        Exclusion4BRule exclusion4BRule = new Exclusion4BRule();
        Result exclusion4BResult = exclusion4BRule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion4BResult.toBoolean()) {
            return result;
        }

        Exclusion4CRule exclusion4CRule = new Exclusion4CRule();
        Result exclusion4CResult = exclusion4CRule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion4CResult.toBoolean()) {
            return result;
        }

        Exclusion4DRule exclusion4DRule = new Exclusion4DRule();
        Result exclusion4DResult = exclusion4DRule.eval(context, patientId, new HashMap<String, Object>());
        if (exclusion4DResult.toBoolean()) {
            return result;
        }

        Element12ARule element12ARule = new Element12ARule();
        Result element12AResult = element12ARule.eval(context, patientId, new HashMap<String, Object>());
        if (element12AResult.toBoolean()) {
            return result;
        }

        Element12BRule element12BRule = new Element12BRule();
        Result element12BResult = element12BRule.eval(context, patientId, new HashMap<String, Object>());
        if (element12BResult.toBoolean()) {
            return result;
        }

        Element12CRule element12CRule = new Element12CRule();
        Result element12CResult = element12CRule.eval(context, patientId, new HashMap<String, Object>());
        if (element12CResult.toBoolean()) {
            return result;
        }

        Element10ARule element10ARule = new Element10ARule();
        Result element10AResult = element10ARule.eval(context, patientId, new HashMap<String, Object>());
        if (element10AResult.toBoolean()) {
            return result;
        }

        Element10BRule element10BRule = new Element10BRule();
        Result element10BResult = element10BRule.eval(context, patientId, new HashMap<String, Object>());
        if (element10BResult.toBoolean()) {
            return result;
        }

        Element10CRule element10CRule = new Element10CRule();
        Result element10CResult = element10CRule.eval(context, patientId, new HashMap<String, Object>());
        if (element10CResult.toBoolean()) {
            return result;
        }

        Element10DRule element10DRule = new Element10DRule();
        Result element10DResult = element10DRule.eval(context, patientId, new HashMap<String, Object>());
        if (element10DResult.toBoolean()) {
            return result;
        }

        Element10ERule element10ERule = new Element10ERule();
        Result element10EResult = element10ERule.eval(context, patientId, new HashMap<String, Object>());
        if (element10EResult.toBoolean()) {
            return result;
        }
        
        result.add(new Result(String.valueOf(parameters.get(ReminderParameters.DISPLAYED_REMINDER_TEXT))));
        return result;
    }

    /**
     * Get the token name of the rule that can be used to reference the rule from LogicService
     *
     * @return the token name
     */
    @Override
    protected String getEvaluableToken() {
        return TOKEN;
    }
}
