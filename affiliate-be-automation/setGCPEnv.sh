# A script to set env variable GCP_REPO_PASSWORD to authenticate mvn to GCP artifactory
echo "Authenticate the gcloud account"
echo "Please make sure gcloud cli is installed in system. If not, refer to https://cloud.google.com/sdk/docs/install-sdk#mac "
brew install jq

gcloud auth application-default login
gcloud config set project secrets-management-development
echo "fetch base64 keys for your account and set environment variable"
var=$(gcloud auth print-access-token)
echo $var
gsm_resp=$(curl --request GET --url "https://secretmanager.googleapis.com/v1/projects/secrets-management-development/secrets/t-rex/versions/latest:access" --header "authorization: Bearer $var" --header 'content-type: application/json' | jq -r ".payload.data" | base64 --decode | jq -r '.artifactory_sa_admin')
#mvn_settings=$(gcloud artifacts print-settings mvn \
#    --project=tkpd-stag-ep-core-47c6 \
#    --repository=te-ep-core-repo \
#    --location=asia-east2)

#mvn_key=$(awk -F'<password>|</password>' '{print $2}' <<< "$mvn_settings")
echo "setting the env variable"
#mvn_key=echo "$gsm_resp"
#echo $sub1
export GCP_REPO_PASSWORD="$gsm_resp"
echo $GCP_REPO_PASSWORD