/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2018 Adobe Systems Incorporated
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
/* global jQuery */
(function($) {
    "use strict";

    var dialogContentSelector = ".cmp-pageheading__editor";
    var titleCheckboxSelector = 'coral-checkbox[name="./pageTitleCheckBox"]';
    var titleTextfieldSelector = 'input[name="./onPageTitle"]';


    var CheckboxTextfieldTuple = window.CQ.CoreComponents.CheckboxTextfieldTuple.v1;
    var titleTuple;


    $(document).on("dialog-loaded", function(e) {
        // assign Type value to the hidden field
        var hiddenTypeVal = $('.page-heading-items').attr('data-pageHeadingTypeValue');
        $('[name="./pageHeadingType"]').val(hiddenTypeVal);

        var $dialog = e.dialog;
        var $dialogContent = $dialog.find(dialogContentSelector);
        var dialogContent = $dialogContent.length > 0 ? $dialogContent[0] : undefined;

        if (dialogContent) {
            titleTuple = new CheckboxTextfieldTuple(dialogContent, titleCheckboxSelector, titleTextfieldSelector);
            retrievePageInfo($dialogContent);
        }
    });



    function retrievePageInfo(dialogContent) {
        var url = (window.location.pathname).replace('/editor.html','').replace('.html','');

        if (url && url.startsWith("/")) {
            return $.ajax({
                url: url + "/_jcr_content.json"
            }).done(function(data) {
                if (data) {
                    titleTuple.seedTextValue(data["pageTitle"]);
                    titleTuple.update();


                }
            });
        } else {
            titleTuple.update();
        }
    }

})(jQuery);
