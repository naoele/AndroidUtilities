package pckk.new_patroid.Tasks;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import pckk.new_patroid.DB.Models.MTJisho;
import pckk.new_patroid.DB.TablesControllers.TJisho;
import pckk.new_patroid.JishoNaiyoIchiranActivity;
import pckk.new_patroid.Models.AsyncTaskResult;
import pckk.new_patroid.NewPatroidApplication;
import pckk.new_patroid.Utilities.AppSettingUtility;
import pckk.new_patroid.Utilities.LogUtility;

/**
 * 一般事象内容一覧画面で入力したコメントを保存する
 */
public class SaveCommentTask extends AsyncTask<MTJisho, Void, AsyncTaskResult<Boolean>> {

    @Override
    protected AsyncTaskResult<Boolean> doInBackground(MTJisho... objects) {
        try {
            // DB更新
            if (!new TJisho(NewPatroidApplication.getAppContext()).updateComment(objects[0].id, objects[0].comment)) {
                throw new IllegalArgumentException("" +
                        "UPDATE t_jisho " +
                        "SET comment = " + objects[0].comment +
                        ", dt_update = current_timestamp" +
                        ", cd_update_user = " + AppSettingUtility.getInstance().CD_USER +
                        " WHERE id = " + objects[0].id + ";");
            }
            return new AsyncTaskResult<Boolean>(true);

        } catch (Exception e) {
            LogUtility.write(Log.ERROR, JishoNaiyoIchiranActivity.class.getSimpleName(), "一般事象内容一覧画面のコメントの保存に失敗しました。", e);
            return new AsyncTaskResult<Boolean>(e);
        }
    }

    @Override
    protected void onPostExecute(AsyncTaskResult<Boolean> result) {
        super.onPostExecute(result);

        if (result.getError() != null) {
            Toast.makeText(NewPatroidApplication.getAppContext(), "コメントの保存に失敗しました。", Toast.LENGTH_SHORT).show();
        }
    }
}
