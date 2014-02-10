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
package org.openmrs.module.clinicalsummary.rule.tuberculosis.element;

import org.apache.commons.lang.time.DateUtils;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.logic.LogicContext;
import org.openmrs.logic.result.Result;
import org.openmrs.module.clinicalsummary.rule.EvaluableConstants;
import org.openmrs.module.clinicalsummary.rule.EvaluableNameConstants;
import org.openmrs.module.clinicalsummary.rule.EvaluableRule;
import org.openmrs.module.clinicalsummary.rule.encounter.EncounterWithRestrictionRule;
import org.openmrs.module.clinicalsummary.rule.encounter.EncounterWithStringRestrictionRule;
import org.openmrs.module.clinicalsummary.rule.observation.ObsWithRestrictionRule;
import org.openmrs.module.clinicalsummary.rule.observation.ObsWithStringRestrictionRule;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * TODO: Write brief description about the class here.
 */
public class Element10DRule extends EvaluableRule {

    public static final String TOKEN = "Tuberculosis:Element 10D";

    /**
     * @param context
     * @param patientId
     * @param parameters
     * @return
     * @see org.openmrs.logic.Rule#eval(org.openmrs.logic.LogicContext, Integer, java.util.Map)
     */
    @Override
    protected Result evaluate(final LogicContext context, final Integer patientId, final Map<String, Object> parameters) {
        Result result = new Result(Boolean.FALSE);

        parameters.put(EvaluableConstants.ENCOUNTER_TYPE,
                Arrays.asList(EvaluableNameConstants.ENCOUNTER_TYPE_ADULT_INITIAL,
                        EvaluableNameConstants.ENCOUNTER_TYPE_ADULT_RETURN));
        parameters.put(EvaluableConstants.ENCOUNTER_FETCH_SIZE, 1);
        EncounterWithRestrictionRule encounterWithRestrictionRule = new EncounterWithStringRestrictionRule();
        Result encounterResults = encounterWithRestrictionRule.eval(context, patientId, parameters);
        if (!encounterResults.isEmpty()) {
            Result encounterResult = encounterResults.get(0);
            Encounter encounter = (Encounter) encounterResult.getResultObject();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(encounter.getEncounterDatetime());
            calendar.add(Calendar.MONTH, -6);
            Date sixMonthsBefore = calendar.getTime();

            String XRAY_CHEST_PRELIMINARY_FINDINGS = "X-RAY, CHEST, PRELIMINARY FINDINGS"; // 012
            String PULMONARY_EFFUSION = "PULMONARY EFFUSION"; // 1136
            String MILIARY_CHANGES = "MILIARY CHANGES"; // 1137
            String EVIDENCE_OF_CARDIAC_ENLARGEMENT = "EVIDENCE OF CARDIAC ENLARGEMENT"; // 5158
            String OTHER_NON_CODED = "OTHER NON-CODED"; // 5622
            String INFILTRATE = "INFILTRATE"; //
            String DIFFUSE_NON_MILIARY_CHANGES = "DIFFUSE NON-MILIARY CHANGES"; // 6050
            String CAVITARY_LESION = "CAVITARY LESION"; // 6052
            String ABNORMAL = "ABNORMAL"; // 1116

            ObsWithRestrictionRule obsWithRestrictionRule = new ObsWithStringRestrictionRule();
            parameters.put(EvaluableConstants.OBS_FETCH_SIZE, 1);
            parameters.put(EvaluableConstants.OBS_CONCEPT, Arrays.asList(XRAY_CHEST_PRELIMINARY_FINDINGS));
            parameters.put(EvaluableConstants.OBS_VALUE_CODED,
                    Arrays.asList(PULMONARY_EFFUSION, MILIARY_CHANGES, EVIDENCE_OF_CARDIAC_ENLARGEMENT,
                            OTHER_NON_CODED, INFILTRATE, DIFFUSE_NON_MILIARY_CHANGES, CAVITARY_LESION, ABNORMAL));
            Result cxrResults = obsWithRestrictionRule.eval(context, patientId, parameters);
            if (!cxrResults.isEmpty()) {
                Result cxrResult = cxrResults.get(0);
                Obs obs = (Obs) cxrResult.getResultObject();
                if (!obs.getObsDatetime().before(sixMonthsBefore)) {
                    return new Result(Boolean.TRUE);
                }
            }

            String SPUTUM_FOR_AFB = "SPUTUM FOR AFB"; // 307
            String THREE_PLUS = "3+"; // 2303
            String TWO_PLUS = "2+"; // 2302
            String ONE_PLUS = "1+"; // 2301
            String POSITIVE = "POSITIVE"; // 703

            parameters.put(EvaluableConstants.OBS_FETCH_SIZE, 1);
            parameters.put(EvaluableConstants.OBS_CONCEPT, Arrays.asList(SPUTUM_FOR_AFB));
            parameters.put(EvaluableConstants.OBS_VALUE_CODED, Arrays.asList(THREE_PLUS, TWO_PLUS, ONE_PLUS, POSITIVE));
            Result sputumResults = obsWithRestrictionRule.eval(context, patientId, parameters);
            if (!sputumResults.isEmpty()) {
                Result sputumResult = sputumResults.get(0);
                Obs obs = (Obs) sputumResult.getResultObject();
                if (!obs.getObsDatetime().before(sixMonthsBefore)) {
                    return new Result(Boolean.TRUE);
                }
            }

            String AFB_CULTURE = "AFB CULTURE"; // 2311
            String MYCOBACTERIUM_TUBERCULOSIS = "MYCOBACTERIUM TUBERCULOSIS"; // 8242
//            String POSITIVE = "POSITIVE"; // 703

            parameters.put(EvaluableConstants.OBS_FETCH_SIZE, 1);
            parameters.put(EvaluableConstants.OBS_CONCEPT, Arrays.asList(AFB_CULTURE));
            parameters.put(EvaluableConstants.OBS_VALUE_CODED, Arrays.asList(MYCOBACTERIUM_TUBERCULOSIS, POSITIVE));
            Result afbResults = obsWithRestrictionRule.eval(context, patientId, parameters);
            if (!afbResults.isEmpty()) {
                Result afbResult = afbResults.get(0);
                Obs obs = (Obs) afbResult.getResultObject();
                if (!obs.getObsDatetime().before(sixMonthsBefore)) {
                    return new Result(Boolean.TRUE);
                }
            }
        }

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
